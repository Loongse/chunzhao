package com.jichu.gainian;

import com.jichu.Main;

//测试switch在1.7以后支持的类型
public class SwitchTest {
    public static void main(String[] args) {
        switch ("string") {
            case "string":
                System.out.println("使用string字符串");
                break;
            default:
        }
        //short、int、char、byte以及包装类型
    }
}
