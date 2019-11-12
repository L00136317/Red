package hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
public class main {
    public static void main(String[] args) throws Exception {
    	    
    	 String data ="Hello World";
    	 String algorithm = "MD5";
    	 byte[] salt = createSalt();
    	 System.out.println("MD5 Hash : " + generateHash(data, algorithm,salt));
    }
    
    private static String generateHash(String data, String algorithm, byte[] salt) throws NoSuchAlgorithmException {
    	MessageDigest digest = MessageDigest.getInstance(algorithm);
    	digest.reset();
    	digest.update(salt);
    	byte[] hash = digest.digest(data.getBytes());
    	return bytesToStringHex(hash);
    }
    
    private final static char[] hexArray = "0123456789ABCDEF" .toCharArray();
    
    public static String bytesToStringHex(byte[] bytes) {
    	char[] hexChars = new char[bytes.length * 2];
    	for (int j = 0; j < bytes.length; j++) {
    		hexChars[j * 2] = hexArray[j >>> 4];
    		hexChars[j * 2 + 1] = hexArray[j & 0x0F];
    	}
    	return new String(hexChars);    
}

 public static byte[] createSalt() {
	 byte[] bytes = new byte[20];
	 SecureRandom random = new SecureRandom();
	 random.nextBytes(bytes);
	 return bytes;
 }
 
}