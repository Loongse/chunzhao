package Shoppe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder clear = new StringBuilder(sc.nextLine().trim().replace("_", " ").toLowerCase());//统一分隔符
        //删除特殊符
        for (int i = 0; i < clear.length(); i++) {
            char ch = clear.charAt(i);
            if (!((ch >= 'a' && ch <= 'z') || ch == ' ' || (ch >= '0' && ch <= '9'))) {
                clear.replace(i, i + 1, "");
            }
        }
        String[] strings = clear.toString().split(" ");
        StringBuilder sb = new StringBuilder();
        //是否已经把第一个单词置为全小写
        for (String string : strings) {
            if (!string.equals("")) {
                String s = string;
                char c = s.charAt(0);//首位判断是否为数字
                if (c >= 'a' && c <= 'z') {
                    //需要换大写
                    StringBuilder temp = new StringBuilder(s);
                    temp.setCharAt(0, (char) (c + 'A' - 'a'));
                    s = temp.toString();
                }
                sb.append(s);
            }
        }
        new ArrayList<Integer>().remove(null);
        System.out.println(sb);
    }
}
