package Honor;

import java.util.*;

//M N
//M：小鸡编号 [2,1000]
//2*N：对应i与j [1,1000]
//需要在N轮之内使得剩余小鸡个数m小于等于1
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();//小鸡初始个数
        int N = sc.nextInt();//游戏轮数

        sc.nextLine();//读取换行
        //第二行为每只小鸡的编号。

        List<Integer> queue = new ArrayList<>();//用于表示小鸡队列
        for (int i = 0; i < M; i++) {
            queue.add(sc.nextInt());//读取小鸡编号
        }
        sc.nextLine();//换行
        int i = 0, j = 0;//用于表示需要抓和保护的小鸡编号
        for (int k = 0; k < N; k++) {
            //一共有N轮
            i = sc.nextInt();
            j = sc.nextInt();
            if (i != j && i <= queue.size()) {//有效攻击
                queue.remove(i - 1);
                if (queue.size() == 1) {
                    System.out.println("Fail! " + queue.get(0));
                    return;//游戏失败返回
                }
            }
        }
        queue.sort(Comparator.comparingInt(o -> o));
        StringBuilder sb = new StringBuilder("Success! ");
        for (Integer integer : queue) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb);
    }
}
