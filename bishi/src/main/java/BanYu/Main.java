package BanYu;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    //字符串压缩，利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能，
    public String compressString(String str) {
        // write code here
        int len = str.length();
        char[] chars = str.toCharArray();
        char ch = chars[0];
        int cnt = 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < len; i++) {
            if (chars[i] == ch) {
                //需要重复
                cnt++;
            } else {
                builder.append(ch).append(cnt);
                cnt = 1;//清零
                ch = chars[i];
            }
        }
        builder.append(ch).append(cnt);
        return builder.length() >= len ? str : builder.toString();
    }

    //一个最多由0,1,2三种元素组成的无序整数数组[0,1,1,1,2,2,0,0...]，要将其按照从小到大排序，时间复杂度为O(n)
    public int[] sort(int[] array) {
        // write code here
        int cnt_0 = 0;
        int cnt_1 = 0;
        int cnt_2 = 0;
        int index = 0;
        for (int i : array) {
            if (i == 0) cnt_0++;
            if (i == 1) cnt_1++;
            if (i == 2) cnt_2++;
        }
        for (int i = 0; i < cnt_0; i++) {
            array[i] = 0;
        }

        for (int i = 0; i < cnt_1; i++) {
            array[i + cnt_0] = 1;
        }
        for (int i = 0; i < cnt_2; i++) {
            array[i + cnt_0 + cnt_1] = 2;
        }
        return array;
    }

    //arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几块，并将这些快分别排序，之后再连接起来，使得连接的结果和按序排序后的原数组相同，请问最多能够将数组分为多少块
    public int maxChunksToSorted(int[] arr) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            if (!stack.isEmpty() && i < stack.peek()) {
                //需要合并到一块内
                int max = stack.pop();
                while (!stack.isEmpty() && i < stack.peek()) {
                    stack.pop();//删除非最大最小值，因为一块只需要使用大的数字和小的数字即可鉴定
                }
                stack.push(max);
            } else {
                stack.push(i);
            }
        }
        return stack.size();
    }

}
