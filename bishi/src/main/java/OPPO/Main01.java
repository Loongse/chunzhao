package OPPO;

public class Main01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组 纸牌构成的数组
     * @return int整型
     */
    public int lottery (int[] nums) {
        // write code here
        int sum_1 = 0,sum_2=0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(i % 2 == 0){
                sum_2 += nums[i];
            }else {
                sum_1 += nums[i];
            }
        }
        return Math.max(sum_1,sum_2);
    }
}
