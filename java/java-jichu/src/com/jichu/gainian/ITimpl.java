package com.jichu.gainian;

interface InterfaceTest {
    public void test();

    default void test1() {
        //java8之后可以使用default关键字在接口中写有方法体的方法
        System.out.println("接口中使用default实现默认方法");
    }

    public static void test2() {
        //Java8中静态方法
        System.out.println("接口中的静态方法");
    }
}

public class ITimpl extends AbstractTest implements InterfaceTest {

    @Override
    public void test() {
        test3();//如果本类中有该静态方法则会使用本类中的而不是父类中的
    }

    //不能重写一个test3 方法因为重写只适用于实例方法不适用于静态方法，子类当中含有和父类相同签名的静态方法一般称之为隐藏
    public static void test3() {
        //隐藏方法
        System.out.println("这是子类中的静态方法");
        AbstractTest.test3();
    }
}

abstract class AbstractTest {
    //抽象类
    abstract void test();

    void test2() {

    }

    public static void test3() {
        System.out.println("这是父类中的静态方法");
    }
}
