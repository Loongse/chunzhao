package vivo;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//读取字符串
        String str = sc.nextLine();
        if (isHuiWen(str)) {
            System.out.println(str);
        } else {
            for (int i = 0; i < str.length(); i++) {
                StringBuilder s = new StringBuilder(str.substring(0,i)).append(str.substring(i+1));
                if(isHuiWen(s.toString()))
                {
                    System.out.println(s);
                    return;
                }
            }
        }
        System.out.println(false);
    }

    public static boolean isHuiWen(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
