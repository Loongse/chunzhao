package Netease;

public class Main03 {
}

class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param orders int整型二维数组
     * @return double浮点型
     */
    public double averageWaitingTime(int[][] orders) {
        if (orders == null || orders.length < 1) return 0;
        // write code here
        long sum = orders[0][0] + orders[0][1], wait = orders[0][1];
        int m = orders.length, n = orders[0].length;
        for (int i = 1; i < m; i++) {
            //判断需要等待与否
            if (sum >= orders[i][0]) {
                //需要等待
                wait += (sum - orders[i][0]);
                wait += orders[i][1];
                sum += orders[i][1];
            } else {
                //不需要等待
                sum = orders[i][1]+orders[i][0];
            }
        }
        return wait / m;
    }
}