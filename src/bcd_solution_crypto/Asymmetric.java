package bcd_solution_crypto;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.Cipher;

public class Asymmetric {
	
	private Cipher cipher;
	
	/*constructor*/
	
	public Asymmetric(String algorithm) {
		try {
			cipher = Cipher.getInstance(algorithm);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Asymmetric() {
		this("RSA"); //call the constructor by matching the input - agrgs list
	}

	// Use Public key to Encrypt
	public String encrypt( String data, PublicKey publicKey ) throws Exception
	{
		String cipherText = null;
		//init
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		//encrypt
		byte[] cipherBytes = cipher.doFinal( data.getBytes() );
		//convert to string
		cipherText = Base64.getEncoder().encodeToString(cipherBytes);
		return cipherText;
		
	}
	
	// Use Private key to decrypt
	public String decrypt( String cipherText, PrivateKey privateKey ) throws Exception
	{
		//init
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		//convert to byte
		byte[] cipherBytes = Base64.getDecoder().decode(cipherText);
		//decrypt
		byte[] dataBytes = cipher.doFinal(cipherBytes);
		return new String(dataBytes);
		
		
	}

}
