package com.xyl.jishu;

import java.util.Arrays;

/**
 * @Auther: Alisa.Xie
 * @Date: 2018年05月14日  14:55:16
 * @Description:
 */
public class MaoPao {
    public static void main(String[] args) {
        int []a=new int[]{1,7,3,8,5,6,4,8,10};
        int swap = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if(a[i]<a[j]){
                    swap = a[i];
                    a[i] = a[j];
                    a[j] = swap;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
