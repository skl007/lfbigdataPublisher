package com.unicom.lfbigdata.publisher.util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESEncrypt {
	/**
	 * 加密
	 * 
	 * @param content 需要加密的内容
	 * @param password 加密密码
	 * @return
	 */
	public static byte[] AESEncrypt(String content, String password) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom random= SecureRandom.getInstance("SHA1PRNG");
			random.setSeed(password.getBytes());
			kgen.init(128, random);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(byteContent);
			return result; // 加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密
	 * 
	 * @param content 待解密内容
	 * @param password 解密密钥
	 * @return
	 */
	public static byte[] AESDecrypt(byte[] content, String password) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom random= SecureRandom.getInstance("SHA1PRNG");
			random.setSeed(password.getBytes());
			kgen.init(128, random);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(content);
			return result; // 加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
    /**将二进制转换成16进制
     * @param buf
     * @return
     */
	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}
	
    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}
	
	public static String encrypt(String content, String password){
		 byte[] encryptResult = AESEncrypt(content, password);
	     String encryptResultStr = parseByte2HexStr(encryptResult);
	     return encryptResultStr;
	}
	
	public static String decrypt(String content, String password){
		 byte[] decryptFrom = parseHexStr2Byte(content);
	     byte[] decryptResult = AESDecrypt(decryptFrom,password);
	     return new String(decryptResult);
	}
	
	public static void main(String[] args) {
        String password = "three.*?";
        /*System.out.println(encrypt("15668333193,1598889818673,865549046286654,460018336316232,018,34103094,114.47654,38.010959,018,2020-09-01 00:04:49.244,A09,V0130100,130104,联通省公司驻留500m\n" +
             "13288748069,1598889941365,862685045338576,460018718206749,018,34103073,114.47654,38.010959,018,2020-09-01 00:06:08.245,A09,V0130100,130104,联通省公司驻留500m\n" +
             "15531239465,1598889939273,863955046899218,460011233449075,018,34190385,114.47654,38.010959,018,2020-09-01 00:06:08.246,A09,V0130100,130104,联通省公司驻留500m\n" , password));*/
        System.out.println(
        		decrypt("40CC3EBA3AE79BB0328F1B40433F0E9A5B02E099DFAEAEC0AE4B10BED5AB050387A518BEC28CF054FDC6C7EB90AA2529FB51C3D9DC0FE5D9B60A3F8D0CAC8D77",
						password));

	}
}
