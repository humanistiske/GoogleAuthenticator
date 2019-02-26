package org.ietf.tools;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;


public class PrintTOTP 
{
	public static String getTOTPCode(String secretKey) 
	{
	    String normalizedBase32Key = secretKey.replace(" ", "").toUpperCase();
	    Base32 base32 = new Base32();
	    byte[] bytes = base32.decode(normalizedBase32Key);
	    String hexKey = Hex.encodeHexString(bytes);
	    long time = (System.currentTimeMillis() / 1000) / 30;
	    String hexTime = Long.toHexString(time);
	    return TOTP.generateTOTP(hexKey, hexTime, "6");
	}
	
	public static void main(String args[])
	{
		String secretKey = "gpe6 mbqv xeb6 giav lpqr w7z6 u37i kx22";
		System.out.println(secretKey.replace(" ", "").toUpperCase());
		String lastCode = null;
		System.out.println(getTOTPCode(secretKey));
		while (true) {
		    String code = getTOTPCode(secretKey);
		    if (!code.equals(lastCode)) {
		        // output a new 6 digit code
		        System.out.println(code);
		    }
		    lastCode = code;
		    try {
		        Thread.sleep(100);
		    } catch (InterruptedException e) {};
		}
		
		/*
		 * String normalizedBase32Key = secretKey.replace(" ", "").toUpperCase(); Base32
		 * base32 = new Base32(); byte[] bytes = base32.decode(normalizedBase32Key);
		 * String hexKey = Hex.encodeHexString(bytes); long time =
		 * (System.currentTimeMillis() / 1000) / 30; String hexTime =
		 * Long.toHexString(time); String code = TOTP.generateTOTP(hexKey, hexTime,
		 * "6");
		 * 
		 * System.out.println(code);
		 */
	}
}
