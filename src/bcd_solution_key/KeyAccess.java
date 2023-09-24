package bcd_solution_key;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyAccess {

// Read public key from CCIM_PublicKey.txt
public static PublicKey getPublicKey() throws Exception{
		
		byte[] keyBytes = Files.readAllBytes(Paths.get(KeyGenerator.CCIM_PUBLIC_KEY));
		//note convert the keyBytes into appropriate keyspec
		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		return KeyFactory.getInstance("RSA").generatePublic(spec);
	}

//Read private key from CCIM_PrivateKey.txt
	public static PrivateKey getPrivateKey() throws Exception{
		
		byte[] keyBytes = Files.readAllBytes(Paths.get(KeyGenerator.CCIM_PRIVATE_KEY));
		//note convert the keyBytes into appropriate keyspec
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		return KeyFactory.getInstance("RSA").generatePrivate(spec);
	}

}
