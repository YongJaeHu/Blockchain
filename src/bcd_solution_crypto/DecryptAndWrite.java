package bcd_solution_crypto;

import java.io.File;
import java.io.FileWriter;
import java.security.PrivateKey;
import java.util.LinkedList;
import java.util.List;
import academy_blockchain.Block;
import academy_blockchain.Blockchain;
import bcd_solution_key.KeyAccess;

public class DecryptAndWrite {
	
	public static void decryptAndWriteToFile(String fileName) throws Exception {
	    File file = new File(fileName);
	    if (!file.exists()) {
	        file.createNewFile();
	    }
	    FileWriter writer = new FileWriter(file);

	    LinkedList<Block> blockchain = Blockchain.get();

	    Asymmetric asymm = new Asymmetric();

	    PrivateKey privateKey = KeyAccess.getPrivateKey();

	    for (int i = 1; i < blockchain.size(); i++) {
	        Block block = blockchain.get(i);
	        List<String> transList = block.getTransaction().getTranxLst();

	        String encryptedData = transList.get(0);

	        String[] parts = encryptedData.split("=");

	        String encryptedText = parts[0];

	        String Text = asymm.decrypt(encryptedText, privateKey);

	        writer.write(Text + "\n");
	    }
	    writer.close();
	}

}
