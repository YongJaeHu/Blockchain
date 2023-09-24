package bcd_solution_signature;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import bcd_solution_key.KeyAccess;


public class App {
	 public static void main(String[] args) throws Exception {		 

		//Read binary key files to String
		 PublicKey pubKey = KeyAccess.getPublicKey();
		 PrivateKey privKey = KeyAccess.getPrivateKey();
		 System.out.println("Public Key = " + Base64.getEncoder().encodeToString(pubKey.getEncoded()));
		 System.out.println("Private Key = " + Base64.getEncoder().encodeToString(privKey.getEncoded()));
		 
	 }
}
