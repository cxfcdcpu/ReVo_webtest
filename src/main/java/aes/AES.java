package aes;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
 
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
 
public class AES {
 
    //private static SecretKeySpec secretKey;
    //private static byte[] key;
 
    public static SecretKeySpec setKey(byte[] key) 
    {
        MessageDigest sha = null;
        SecretKeySpec secretKey = null;
        try {
            //key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        return secretKey;

    }
 
    public static byte[] encrypt(byte[] dataToEncrypt, byte[] secret) 
    {
    	MessageDigest sha = null;
        try
        {
        	SecretKeySpec secretKey = setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
           
            byte[] msg_ct = cipher.doFinal(dataToEncrypt);
            byte[] cat_msg = ByteBuffer.allocate(secret.length+msg_ct.length).put(secret).put(msg_ct).array();
            sha = MessageDigest.getInstance("SHA-224");
            byte[] VK = sha.digest(cat_msg);
            byte[] ret = ByteBuffer.allocate(VK.length+msg_ct.length).put(VK).put(msg_ct).array();
            return ret;
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
 
    public static byte[] decrypt(byte[] dataToDecrypt, byte[] secret) 
    {
    	MessageDigest sha = null;
        try
        {
        	byte[] VK = Arrays.copyOfRange(dataToDecrypt, 0, 224);
        	byte[] msg_ct = Arrays.copyOfRange(dataToDecrypt, 224,dataToDecrypt.length);        	
            byte[] cat_msg = ByteBuffer.allocate(secret.length+msg_ct.length).put(secret).put(msg_ct).array();
            
            
            sha = MessageDigest.getInstance("SHA-224");
            if(!Arrays.equals(VK,sha.digest(cat_msg))) {
            	return null;
            }
        	
        	SecretKeySpec secretKey = setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            
            return cipher.doFinal(Base64.getDecoder().decode(msg_ct));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}