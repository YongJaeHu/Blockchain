package bcd_solution_crypto;

import java.security.PrivateKey;
import java.util.LinkedList;
import java.util.List;

import studentID_blockchain.Block;
import studentID_blockchain.Blockchain;
import bcd_solution_key.KeyAccess;

public class Student_Decrypt {
	
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
		LinkedList<Block> blockchain = Blockchain.get();
		
		Asymmetric asymm = new Asymmetric();
		
		PrivateKey privateKey = KeyAccess.getPrivateKey();
		
		for (int i = 1; i < blockchain.size(); i++) {
			Block block = blockchain.get(i);
			List<String> transList = block.getTransaction().getTranxLst();
			
			String encryptedData = transList.get(0);
			
			String[] parts = encryptedData.split("=");
			
			String encryptedText = parts[0];
			
			String decryptedText = asymm.decrypt(encryptedText, privateKey);
			System.out.println(decryptedText);
		}
	}
}
