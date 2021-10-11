package cn.moquan.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static String encryptMD5(String resource){

        MessageDigest md5 = null;

        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(" Error: 没有这个算法 \n Path: cn.moquan.util.MD5Util.encryptMD5(String resource)");
            e.printStackTrace();
        }

        if(md5 == null)
            return null;

        md5.update(resource.getBytes());

        byte[] secretByte = md5.digest();

        String md5Code = new BigInteger(1, secretByte).toString(16);

        for (int i = 0; i < 32 - md5Code.length(); i++) {
            md5Code = "0" + md5Code;
        }

        return md5Code;
    }
}
