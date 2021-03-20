package CSDC;

import java.util.*;

//在一个字符串中找到第一个只出现一次的字符
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        int len = str.length();
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (str.charAt(i) == str.charAt(j))
                    a[i] = a[j] = -1;
            }
        }
        for (int i = 0; i < len; i++) {
            if (a[i] == 0) {
                System.out.println(str.charAt(i));
                return;
            }
        }
    }
}
