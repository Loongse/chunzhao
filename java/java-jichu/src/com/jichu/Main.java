package com.jichu;


import com.jichu.gainian.ITimpl;

public class Main {
    public static void main(String[] args) {
        // write your code here
        new ITimpl().test();
        ITimpl.test3();
        //测试string
        String s1 = "ab";
        String s2 = "a" + "b";
        String s3 = "a";
        String s4 = "b";
        String s5 = s3 + s4;
        System.out.println("s1 == s2:" + (s1 == s2));//true
        System.out.println("s1 == s5:" + (s1 == s5));//false
        System.out.println("s2 == s5:" + (s2 == s5));//false
//        测试intern方法
        String ss1 = "aa";
        String ss2 = ss1.intern();
        System.out.println("ss1 == ss2:" + (ss1 == ss2));//true

        String ss3 = new String("bb");
        String ss4 = ss3.intern();
        System.out.println("ss3 == ss4:" + (ss3 == ss4));//false,此时不是在常量池中的，所以会不相等
        //自动类型转换
        byte a = 127;
        byte b = 127;
        //b = a + b;
        /**Required type: byte 因为这里不管溢出与否，都会提升为int类型
         Provided: int*/
        b += a;//ok
        //自动类型提升
        //short si1= 1; si1 = si1 + 1;
        //不会自动类型提升

        //测试finally块
        //1 一定会执行此块内代码
        try{

        }finally {
            System.out.println("这是finally中的代码");
        }
        //2 return值从何而来
        System.out.println(testFinally());//0
        //当finally中不返回但是改变了值以后
        System.out.println(testFinallyReturn());
    }
    static int testFinally(){
        //测试返回值
        try{
            return 1;
        }finally {
            return 0;
        }
    }
    static int testFinallyReturn(){
        int x = 110;
        try{
            return x;//这里就会预存返回值
        }finally {
            x =10;//这里的修改不会影响前面的返回值
        }
    }
}
