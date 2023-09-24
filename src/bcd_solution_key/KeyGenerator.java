package bcd_solution_key;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;


public class KeyGenerator {
	
	private static final String ALGORITHM = "RSA";

    private KeyPairGenerator keygenerator;
    private KeyPair keypair;
    public static PublicKey publicKey;
    public static PrivateKey privateKey;

    public static final String MasterDir ="src/masterFile";
   
    public static final String CCIM_PUBLIC_KEY = MasterDir + "/CCIM_PublicKey.txt";
    public static final String CCIM_PRIVATE_KEY =  MasterDir + "/CCIM_PrivateKey.txt";

    public static PublicKey getPublicKey() {
        return publicKey;
    }

    public static PrivateKey getPrivateKey() {
        return privateKey;
    }

    public KeyGenerator() {
        try{
            //instantiate key pair generator
        	keygenerator = KeyPairGenerator.getInstance( ALGORITHM );
        	keygenerator.initialize(2048);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void create(){
        KeyGenerator CCIMKey = new KeyGenerator();

        //generate CCIM's public key & private key 
        CCIMKey.keypair = CCIMKey.keygenerator.generateKeyPair();

        //get key and save in binary file
        publicKey = CCIMKey.keypair.getPublic();
        putKey(publicKey.getEncoded(), CCIM_PUBLIC_KEY); 

        privateKey = CCIMKey.keypair.getPrivate();
        putKey(privateKey.getEncoded(), CCIM_PRIVATE_KEY);
    }

    public static void putKey( byte[] keyBytes, String fileName) { 
    	File f = new File(fileName);
		f.getParentFile().mkdirs();
    	try {
            Files.write(Paths.get(fileName), keyBytes, StandardOpenOption.CREATE);
            System.out.println("Key saved in file: " + fileName);
        } catch (NoSuchFileException e) {
            try {
                Files.createFile(Paths.get(fileName));
                Files.write(Paths.get(fileName), keyBytes, StandardOpenOption.CREATE);
                System.out.println("Created file and saved key in file: " + fileName);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
