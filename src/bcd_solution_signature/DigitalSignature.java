package bcd_solution_signature;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

import bcd_solution_crypto.Asymmetric;
import bcd_solution_key.KeyAccess;

public class DigitalSignature {
	
	private Signature sig;
    
    public DigitalSignature() {    	
	     	super();
	        
	        try {	        	
	            sig = Signature.getInstance( "SHA256WithRSA" );	            
	        } 
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	/*     
	* sign()     
	*/    
	    public String sign(String data, PrivateKey key) throws Exception    
	    {
	       sig.initSign( key );
	       sig.update(data.getBytes());
	       return Base64.getEncoder().encodeToString(sig.sign());
	    }
    /**     
     * verify()     
    */ 
    	
    	public boolean verify(String data, String signature, PublicKey key) throws Exception    
    	{
	       sig.initVerify( key );
	       sig.update(data.getBytes());
	       return sig.verify( Base64.getDecoder().decode(signature));
    	}
    	
    	public static String SignedDoc (String tranx)throws Exception
    	{
    		DigitalSignature signature = new DigitalSignature();
    		    		  		
    		Asymmetric amc = new Asymmetric();
    		
    		//sign transaction
            String signed = signature.sign(tranx, KeyAccess.getPrivateKey());
            
    		if(!signature.verify(tranx, signed, KeyAccess.getPublicKey())) {
    			throw new Exception("Signature Verification failed");
    		}
    		
    		String EncryptedDoc = amc.encrypt(tranx, KeyAccess.getPublicKey());
    			
    		String SignedDoc = EncryptedDoc + "|" + signed;
    		
    		return SignedDoc;
    		
    	}
}
