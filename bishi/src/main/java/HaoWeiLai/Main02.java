package HaoWeiLai;

import java.util.Scanner;

//十六进制转十进制
public class Main02 {
    public static void main(String... args) {
        Scanner input = new Scanner(System.in);
        String content = input.nextLine();
        System.out.println(covert(content));
    }

    public static int covert(String content) {
        //content的第一位用来判断是否为负数
        boolean s = true;//true表示正数
        if (content.charAt(0) == '-') s = false;
        int len = content.length();
        content = content.toUpperCase();//转换为大写
        //从后往前遍历，如果遇到X x则表示遍历完成，与符号进行合并即可
        int res = 0;//表示结果和进位
        long bit = 1;
        for (int i = len - 1; i >= 0; i--) {
            char c = content.charAt(i);
            if (c == 'X' || c == 'x') {
                break;
            } else if (c >= '0' && c <= '9') {
                res += (c - '0') * bit;
            } else {
                res += (c - 'A' + 10) * bit;
            }
            bit = bit * 16;
        }
        return s ? res:-res;
    }
}
