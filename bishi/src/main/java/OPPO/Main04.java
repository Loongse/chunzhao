package OPPO;

public class Main04 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param values int整型一维数组
     * @return long长整型
     */
    public long caculateCommonMultiple(int[] values) {
        // write code here
        long res = 1;
        int len = values.length;
        for (int value : values) {
            res = commonMul(res, value);
        }
        return res;
    }

    public long commonMul(long x, int y) {
        long max = Math.max(x, y);
        long res = x * y;
        for (long i = max; i <= res; i++) {
            if (i % x == 0 && i % y == 0) {
                res = i;
                break;
            }
        }
        return res;
    }
}
