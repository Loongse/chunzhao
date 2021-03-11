package ShunFeng;

import java.math.BigInteger;
import java.util.*;

public class Main01 {
    public static void main(String[] args) {
        //去掉最高分和最低分的平均分
        Scanner sc = new Scanner(System.in);
        //评委数和查询数字
        int n = sc.nextInt();//评委数
        int q = sc.nextInt();//查询数
        sc.nextLine();//换行
//        int[] score = new int[n];//存储分数
        List<Integer> score = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            score.add(sc.nextInt());
        }
        sc.nextLine();//换行
        while (q-- > 0) {//循环读取区间
            int L = sc.nextInt();
            int R = sc.nextInt(); sc.nextLine();//换行
            if(R-L < 2){
                System.out.println("NoScore");//无效区间
            }else{
                System.out.println(avr(score,L,R));
            }
        }
    }
    public static String avr(List<Integer> score,int L,int R){
        BigInteger sum = new BigInteger("");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < R-L+1; i++) {
            int cur = score.get(L+i-1);
            sum.add(new BigInteger(cur+""));
            min = Math.min(min,cur);
            max = Math.max(max,cur);
        }
        sum.subtract(new BigInteger((min+max)+""));
        return sum.divide(new BigInteger((R-L+1)+"")).toString();
    }
}
