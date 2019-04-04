package com.test.aes;

/**
 * Created by meridian on 2018/9/19.
 */
public class Test {
    //输入n，返回第n位的斐波那契数
    public static void main(String[] args) {
       /* Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int s = f(n);
        System.out.println("----------->"+s);
        int p = f1(n);
        System.out.println("------------"+p);*/
        Double d1 = new Double("1");
        Double d2 = new Double("1");
        System.out.println(d1==d2);
        System.out.println(d1.equals(d2));
        System.out.println("------------->");
        Double d3 = new Double("3");
        Double d4 = new Double("4");
        System.out.println(d3!=d4);
        System.out.println(d3.equals(d4));
        System.out.println("------------->");



    }
    static int f(int n){
        if(n==1 || n==2){
            return 1;
        }
        return f(n-1)+f(n-2);
    }

    public static  int f1(int n){
        int f0 = 1;
        int f1 = 1;
        for (int i = 2;i<n;i++){
            int f2 = f1+f0;
            f0 = f1;
            f1 =  f2;
        }
        return f1;
    }
}
