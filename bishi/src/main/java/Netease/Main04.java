//package Netease;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.PriorityQueue;
//
//public class Main04 {
//}
//
//class Solution {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     * <p>
//     * 调度jobs中的任务，分配给k个worker处理，返回系统最短的处理时间
//     *
//     * @param jobs int整型一维数组 翻译时长数组
//     * @param k    int整型 开启翻译线程数
//     * @return int整型
//     */
//    public int minimumProcessTime(int[] jobs, int k) {
//        // write code here
//        Arrays.sort(jobs);
//        int len = jobs.length;
//        if (k >= len) return jobs[len - 1];//最长的
//
//        int sum = 0;//总和，求平均值
//        for (int job : jobs) {
//            sum += job;
//        }
//        int avr = sum / k;
//        List<Integer> list = new ArrayList<>(k);
//        for (int job : jobs) {
//            for (int i = 0; i < list.size(); i++) {
//                if(list.get(i) + job <= avr){
//                    list.set(i,list.get(i));
//                }else{
//            }
//        }
//    }
//}