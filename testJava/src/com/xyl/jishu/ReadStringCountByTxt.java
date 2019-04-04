package com.xyl.jishu;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年05月14日  14:44:21
 * @Description:
 */
public class ReadStringCountByTxt {
    public static void main(String[] args) {
        try{
            InputStream is = new FileInputStream("E://1.txt");
            byte b[] = new byte[1024];
            int c= is.read(b);
            String[] a=new String(b,0,c).split("");
            int count = 0;
            for (int i = 0; i < a.length; i++) {
                if("a".equals(a[i])){
                    count+=1;
                }
            }
            System.out.println(count);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
