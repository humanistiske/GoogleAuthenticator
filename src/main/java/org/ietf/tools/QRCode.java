package org.ietf.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class QRCode 
{
	public static String getGoogleAuthenticatorBarCode(String secretKey, String account, String issuer) {
	    String normalizedBase32Key = secretKey.replace(" ", "").toUpperCase();
	    try {
	        return "otpauth://totp/"
	        + URLEncoder.encode(issuer + ":" + account, "UTF-8").replace("+", "%20")
	        + "?secret=" + URLEncoder.encode(normalizedBase32Key, "UTF-8").replace("+", "%20")
	        + "&issuer=" + URLEncoder.encode(issuer, "UTF-8").replace("+", "%20");
	    } catch (UnsupportedEncodingException e) {
	        throw new IllegalStateException(e);
	    }
	}
	
	public static void main(String args[])
	{
		System.out.println(
				getGoogleAuthenticatorBarCode("gpe6 mbqv xeb6 giav lpqr w7z6 u37i kx22",
						"test@example.com","Test Company"));
	}
}
