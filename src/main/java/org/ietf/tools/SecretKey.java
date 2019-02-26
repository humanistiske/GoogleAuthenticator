package org.ietf.tools;

import java.security.SecureRandom;
import org.apache.commons.codec.binary.Base32;

public class SecretKey 
{
	public static String getRandomSecretKey() 
	{
	    SecureRandom random = new SecureRandom();
	    byte[] bytes = new byte[20];
	    random.nextBytes(bytes);
	    Base32 base32 = new Base32();
	    String secretKey = base32.encodeToString(bytes);
	    // make the secret key more human-readable by lower-casing and
	    // inserting spaces between each group of 4 characters
	    return secretKey.toUpperCase().replaceAll("(.{4})(?=.{4})", "$1");
	}
	
	public static void main(String args[])
	{
		System.out.println(getRandomSecretKey());
	}
}
