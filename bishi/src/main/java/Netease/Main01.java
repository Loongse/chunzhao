//package Netease;
//
//import java.util.HashSet;
//
////找到唯一重复的数字
//public class Main01 {
//}
//
//class Solution {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     * <p>
//     * 返回重复数字
//     *
//     * @param nums int整型一维数组
//     * @return int整型
//     */
//    public int duplicate(int[] nums) {
//        // write code here
//        HashSet<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            if (set.contains(num)) return num;
//            set.add(num);
//        }
//        return -1;
//    }
//}