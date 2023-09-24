package hash;

import java.security.SecureRandom;
import java.util.Base64;

public class Salt {
	
	//generate salt : byte[]
	public static byte[]generate() 
	{
		int size = 16;
		byte[] b = new byte[size];
		SecureRandom sr = new SecureRandom();
		sr.nextBytes(b);
		return b;
	}
	//generate
	/*
	public static void main(String[] args) 
	{
		System.out.println("Salt: " + Base64.getEncoder().encodeToString(Salt.generate()));
	}
	*/

}
