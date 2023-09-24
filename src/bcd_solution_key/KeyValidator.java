package bcd_solution_key;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class KeyValidator {
    private static boolean keysGenerated = false;

    public static boolean validateKeys() {
        if (keysGenerated) {
            return true;
        }
        // validate
        String publicKeyPath = "src/masterFile/CCIM_PublicKey.txt";
        String privateKeyPath = "src/masterFile/CCIM_PrivateKey.txt";
        File publicKeyFile = new File(publicKeyPath);
        File privateKeyFile = new File(privateKeyPath);
        
        if (!publicKeyFile.exists() || !privateKeyFile.exists()) {
            // key files not found
            return false;
        }
        
        Path publicKeyFilePath = Paths.get(publicKeyPath);
        Path privateKeyFilePath = Paths.get(privateKeyPath);
        long publicKeySize, privateKeySize;
        try {
            publicKeySize = Files.size(publicKeyFilePath);
            privateKeySize = Files.size(privateKeyFilePath);
        } catch (IOException e) {
            // error reading file size
            return false;
        }
        
        if (publicKeySize == 0 || privateKeySize == 0) {
            // key files are empty
            return false;
        }
        
        // keys are valid, set keysGenerated flag to true
        keysGenerated = true;
        return true;
    }
}
