package com.xyl.number;

/**
 * Created by meridian on 2018/11/26.
 */
public class BigNumberSum {
    public static void main(String[] args) {
        System.out.println(bigNumSum("426709752318","95481253129"));
    }

    /**
     * 大整合数求和
     * @param bigNumberA    大整数A
     * @param bigNumberB    大整数B
     */
    public static String bigNumSum(String bigNumberA,String bigNumberB){
        //先把两个大整数用数组逆序存储
        char[] charA = new StringBuffer(bigNumberA).reverse().toString().toCharArray();
        char[] charB = new StringBuffer(bigNumberB).reverse().toString().toCharArray();
        //构建result数组，数组长度等于较大整数位+1
        int maxLength = charA.length>charB.length?charA.length:charB.length;
        int result[] = new int[maxLength+1];
        //遍历数组，按位相加
        for(int i=0;i<result.length;i++){
            int temp = result[i];
            //-'0'操作 为了把char类型的数字字符转成对应的整型
            if(i<charA.length){
                temp+=charA[i]-'0';
            }
            if(i<charB.length){
                temp+=charB[i]-'0';
            }
            //判断是否进位
            if(temp>=10){
                temp = temp -10;
                result[i+1]=1;
            }
            result[i] = temp;
        }
        //将result数组再次逆序并转成String
        StringBuffer sb = new StringBuffer();
        boolean flag = true;
        for(int i=result.length-1;i>=0;i--){
            if(result[i]==0 & flag){
                continue;
            }
            flag = false;
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
