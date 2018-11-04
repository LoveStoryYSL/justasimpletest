package com.xtu.liuli.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordUtil 
{
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	private final static String ASCII="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static String getMd5String(String password)
	{
        if (password != null)
        {
            try 
            {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] results = md.digest(password.getBytes());
                String resultString = byteArrayToHexString(results);
                return resultString.toUpperCase();
            } catch (Exception ex) 
            {
                ex.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /**
     * 转换字节数组为16进制字串
     * 
     * @param b  字节数组
     * @return 十六进制字串
     */
    private static String byteArrayToHexString(byte[] b) 
    {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /**
     * 将一个字节转化成16进制形式的字符串
     * @param b
     * @return
     */
    private static String byteToHexString(byte b)
    {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
	public static String getSalt()
	{
		int index;
		SecureRandom rand=new SecureRandom();
		String salt="";
		for(int i=0;i<16;i++)
		{
			index=rand.nextInt(ASCII.length());
			salt+=ASCII.charAt(index);
		}
		return salt;
	}
}
