package Shoppe;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();//骆驼最大承重
        System.out.println((cycleNum(num) % 3 == 0) ? 1 :0);
    }

    public static int cycleNum(int num) {
        //计算num承重下能够坚持的回合数
        int n1 = 1;//第一回合
        int n2 = 1;//第二回合
        int sum = 2;//第一二回合的承重
        int cur = 0;//当前回合需要放入的
        int cnt = 2;
        while (sum <= num) {
            cur = n1 + n2;
            sum += cur;
            cnt++;
        }
        return cnt;
    }
}
