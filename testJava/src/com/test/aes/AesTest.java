package com.test.aes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年07月31日  13:47:52
 * @Description:
 */
public class AesTest {
    private static DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
    private static DateFormat format_full = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws Exception{
       /* String algorithm = "AES";
        String charSet = "UTF-8";
        String message = "http://www.dubby.cn";
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        keyGenerator.init(256);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        String s = byteToHexString(enCodeFormat);
        System.out.println(s);
        System.out.println("十六进制密钥长度为"+s.length());
        System.out.println("二进制密钥的长度为"+s.length()*4);*/
       String date = "20180918213515";
        Date d = format.parse(date);
        System.out.println(format_full.format(d));
    }
    /**
     * byte数组转化为16进制字符串
     * @param bytes
     * @return
     */
    public static String byteToHexString(byte[] bytes){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String strHex=Integer.toHexString(bytes[i]);
            System.out.println("----------------->"+strHex);

            if(strHex.length() > 3){
                sb.append(strHex.substring(6));
            } else {
                if(strHex.length() < 2){
                    sb.append("0" + strHex);
                } else {
                    sb.append(strHex);
                }
            }
        }
        return  sb.toString();
    }
}
