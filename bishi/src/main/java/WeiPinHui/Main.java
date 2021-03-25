package WeiPinHui;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

    //给定一个包括n个整数的数组nums和一个目标值target。找出nums中的三个整数，使得他们的和与target最接近。返回这三个数的和
    public int threeSumClosest(int[] nums, int target) {
        // write code here
        int distance = Integer.MAX_VALUE;//默认相差的最大值
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (distance > Math.abs(target - sum)) {
                        res = sum;
                        distance = Math.abs(target - sum);
                    }
                }
            }
        }
        return res;
    }

    //给定一个无序数组，包含正数、负数和0，要求从中找出三个数的乘积使得最大，
    public int maximumProduct(int[] nums) {
        // write code here//两种情况：最大*最小两个数字（如果存在两个以上负数可能为最大值） 最大三个数字相乘
        int max_01 = Integer.MIN_VALUE, max_02 = Integer.MIN_VALUE, max_03 = Integer.MIN_VALUE;
        int min_01 = Integer.MAX_VALUE, min_02 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max_01) {
                //需要更新三个数字
                max_03 = max_02;
                max_02 = max_01;
                max_01 = num;
            } else if (num > max_02) {
//更新两个数字
                max_03 = max_02;
                max_02 = num;
            } else if (num > max_03) {
                max_03 = num;
            }
            if (num < min_01) {
//更新两个数字
                min_02 = min_01;
                min_01 = num;
            } else if (num < min_02) {
                min_02 = num;
            }
        }
        return Math.max(max_01 * max_02 * max_03, max_01 * min_01 * min_02);
    }
}

