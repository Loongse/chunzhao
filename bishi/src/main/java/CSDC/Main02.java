package CSDC;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int res = 1;
        while (true) {
            if (res % num == 0) {
                System.out.println(String.valueOf(res).length());
                return;
            }
            res = res * 10 + 1;
        }
    }
}
