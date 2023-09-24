package hash;

import java.security.MessageDigest;
import java.util.Base64;

import org.apache.commons.codec.binary.Hex;

public class Hasher {
	
	/*md5 accept string and return string*/
	
//	public static String md5(String input) 
//	{
//		return hash(input,"MD5");
//	}
//	
//	public static String md5_salted(String input, byte[] salt) 
//	{
//		return hash(input,"MD5", salt);
//	}
	//sha256
	public static String sha256(String input)
	{
		return hash(input, "SHA-256");
	}
	
	public static String sha256_salted(String input, byte[]salt)
	{
		return hash(input, "SHA-256", salt);
	}
	
	
	private static String hash(String input, String algorithm) 
	{
		String hashCode = "";
		
		try 
		{
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(input.getBytes());
			//digesting...
			byte[] hashBytes = md.digest();
			//convert the byte array to String
			
			//Option 1
			//hashCode = Base64.getEncoder().encodeToString(hashBytes);
			
			//Option 2 hex format output
			//External library
			hashCode = Hex.encodeHexString(hashBytes);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return hashCode;
	}
	
	private static String hash(String input, String algorithm, byte[]salt) 
	{
		String hashCode = "";
		
		try 
		{
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(input.getBytes());
			md.update(salt);
			//digesting...
			byte[] hashBytes = md.digest();
			//convert the byte array to String
			
			//Option 1
			//hashCode = Base64.getEncoder().encodeToString(hashBytes);
			
			//Option 2 hex format output
			//External library
			hashCode = Hex.encodeHexString(hashBytes);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return hashCode;
	}


}
