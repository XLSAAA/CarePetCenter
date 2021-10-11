package cn.moquan.test;

import cn.moquan.util.MD5Util;
import org.junit.Test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MD5Test {

    @Test
    public void encryptMD5() throws NoSuchAlgorithmException {
        // 使用自带MD5加密
        // 设置加密方式
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        // 设置加密文本
        md5.update("123456".getBytes());
        // 获取加密文本
        byte[] bytes = md5.digest();

        /*
                public BigInteger(int signum, byte[] magnitude) {
                    this.mag = stripLeadingZeroBytes(magnitude);

                    if (signum < -1 || signum > 1)
                        throw(new NumberFormatException("Invalid signum value"));

                    if (this.mag.length == 0) {
                        this.signum = 0;
                    } else {
                        if (signum == 0)
                            throw(new NumberFormatException("signum-magnitude mismatch"));
                        this.signum = signum;
                    }
                    if (mag.length >= MAX_MAG_LENGTH) {
                        checkRange();
                    }
                }
         */

        // 将数据转为 16 进制 字符串
        String secretCode = new BigInteger(1, bytes).toString(16);

        // 补位
        for (int i = 0; i < 32 - secretCode.length(); i++) {
            secretCode = "0" + secretCode;
        }

        // 输出y
        System.out.println(secretCode);
        System.out.println(secretCode.length());

        System.out.println(" ==== MD5util ====");
        System.out.println(MD5Util.encryptMD5("123456"));
    }

}
