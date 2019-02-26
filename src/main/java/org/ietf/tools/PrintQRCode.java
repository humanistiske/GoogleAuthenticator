package org.ietf.tools;

import java.io.FileOutputStream;
import java.io.IOException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class PrintQRCode 
{
	public static void createQRCode(String barCodeData, String filePath, int height, int width)
            throws WriterException, IOException {
    BitMatrix matrix = new MultiFormatWriter().encode(barCodeData, BarcodeFormat.QR_CODE,
            width, height);
    		try (FileOutputStream out = new FileOutputStream(filePath)) {
    			MatrixToImageWriter.writeToStream(matrix, "png", out);
    		}
	}
	
	public static void main(String args[])
	{
		try {
			createQRCode("otpauth://totp/Test%20Company%3Atest%40example.com?secret="
					+ "GPE6MBQVXEB6GIAVLPQRW7Z6U37IKX22&issuer=Test%20Company\r\n",
					"C://file.png",400,400);
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
