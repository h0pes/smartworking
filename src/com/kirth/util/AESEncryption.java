/**
 * This class is used to encrypt the secret token
 * send along the mail. USE SECRET KEY OF LENGTH 16.
 * 
 * @version: v.1.0 - 10 mag 2016 13:26:09 
 * @author:  Marco Canavese
 */
package com.kirth.util;

import java.util.ResourceBundle;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/*
 * 
 * This class is used to encrypt the secret token send along the mail. USE SECRET KEY OF LENGTH 16.
 */
public class AESEncryption
{
	private static final String ALGO = "AES";
	private static ResourceBundle rb2 = ResourceBundle.getBundle("com.kirth.util\\DB");
	private static String key = rb2.getString("secretkeyforpass");
	private static final byte[] keyValue = key.getBytes();

	/**
	 * This method encrypts a token string.
	 * 
	 * @param Data
	 * @return the encrypted token value
	 * @throws Exception
	 */
	public static String encrypt(String Data) throws Exception
	{
		SecretKeySpec key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data.getBytes());
		String encryptedValue = new BASE64Encoder().encode(encVal);
		return encryptedValue;
	}

	/**
	 * This method decrypts a token string.
	 * 
	 * @param encryptedData
	 * @return the decrypted token value
	 * @throws Exception
	 */
	public static String decrypt(String encryptedData) throws Exception
	{
		SecretKeySpec key = generateKey();
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
		byte[] decValue = c.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}

	/**
	 * This method generates a secret key using a given value and algorithm.
	 * 
	 * @return a secret key
	 * @throws Exception
	 */
	private static SecretKeySpec generateKey() throws Exception
	{
		SecretKeySpec key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}

}
