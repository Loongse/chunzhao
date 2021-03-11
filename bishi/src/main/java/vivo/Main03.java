package vivo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//矩阵大小
        sc.nextLine();
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int endX = sc.nextInt();
        int endY = sc.nextInt();
        //读取矩阵数据
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> l = new ArrayList<>();
            String str = sc.nextLine();
            for (int j = 0; j < str.length(); j++) {
                l.add(parse(str.charAt(j)));//转换地图信息
            }
            list.add(l);
        }
        System.out.println(search(N,startX,startY,endX,endY,list));
    }

    private static int search(int n, int startX, int startY, int endX, int endY, ArrayList<ArrayList<Integer>> list) {
        int sum = 0;//路径长
        
    }

    private static Integer parse(char charAt) {
        if(charAt>='0' && charAt<='9'){
            return Integer.parseInt(charAt+"");
        }else if(charAt == '#' || charAt == '@'){
            return -1;
        }else return 1;
    }
}
