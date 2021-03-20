package DiDi;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        int len = str.length();
        int max = 1;
        for (int i = 0; i < len; i++) {
            if (max > (len - i)) break;
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > max) {
                    if (isHuiWen(str.substring(i, j + 1))) {
                        max = j - i + 1;
                    }
                }
            }
        }
        System.out.println(max);
    }

    public static boolean isHuiWen(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != '*' && str.charAt(len - i - 1) != '*' && (str.charAt(i) != str.charAt(len - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
