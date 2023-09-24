package bcd_solution_crypto;

import java.io.File;
import java.io.FileWriter;
import java.security.PrivateKey;
import java.util.LinkedList;
import java.util.List;

import academy_blockchain.Block;
import academy_blockchain.Blockchain;
import bcd_solution_key.KeyAccess;

public class Decrypt {
	
	public static void main(String[] args) throws Exception{
		// Get the blockchain using get() method
/*		LinkedList<Block> list = new LinkedList<Block>();
        list = Blockchain.get();
        
        List<String> TranxList = null;
		Asymmetric asymm = new Asymmetric();
		
		
		for (int i = 1; i < list.size(); i++) 
		{
			TranxList = list.get(i).getTransaction().getTranxLst();
            //split the transaction list with digital signature
            String[] tranx = TranxList.get(0).toString().split("=");
			
			//decrypt
			String Text = asymm.decrypt(tranx[0], KeyAccess.getPrivateKey());			
			System.out.println(Text); 
		
		}
	}*/	
		File file = new File("src/masterFile/Decrypted_text.txt");
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
			//System.out.println(Text);
			
			writer.write(Text + "\n");
		}
		writer.close();
	}
}
