package XingYeShuJin;

import java.util.Scanner;

/**
 * 题目描述
 * 输入一个正整数数，计算输出距离它最近的对称数，如果存在多个相同距离的对称数，则以从小到大的顺序，逗号分割输出。当输入不合法时，输出“ERROR”。例如：输入103，输出101。
 * 输入描述:
 * 一个正整数
 * 输出描述:
 * 距离最近的对称数
 * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 复制
 * 103
 * 输出
 * 复制
 * 101
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n <= 0)
            System.out.println("ERROR");
        else
            printDuiChen(n);
    }

    //输出对称数
    private static void printDuiChen(int n) {
        int x = 1;
        if (isDuiChen(n)) {
            System.out.println(n);
            return;
        }
        while (true) {
            if (isDuiChen(n - x) || isDuiChen(n + x)) {
                if (isDuiChen(n - x) && isDuiChen(n + x)) {
                    System.out.println((n - x) + "," + (n + x));
                } else {
                    if (isDuiChen(n - x)) {
                        System.out.println(n - x);
                    }
                    if (isDuiChen(n + x)) {
                        System.out.println(n + x);
                    }
                }
                return;
            }
            x++;
        }
    }

    //判断是否为对称数
    private static boolean isDuiChen(int n) {
        if (n <= 0) return false;
        String s = n + "";
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
