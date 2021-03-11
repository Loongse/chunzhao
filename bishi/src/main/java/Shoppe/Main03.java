package Shoppe;

import java.math.BigInteger;
import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine().trim();
        String num2 = sc.nextLine().trim();
        BigInteger big1 = new BigInteger(num1);
        BigInteger big2 = new BigInteger(num2);
        System.out.println(big1.add(big2));
    }
}
