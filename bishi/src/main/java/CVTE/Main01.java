package CVTE;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * 个人公众号统计用户年龄。
 * 输入:[16,16,16,18,18,20] k=2
 * 输出：[16,18]
 */
public class Main01 {
    public static void main(String[] args) {

    }

    public int[] topK(int[] nums, int k) {
        //nums为输入的数组，k为需要输出的top个数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int[] out = new int[k];//输出数组
        PriorityQueue<NumAndCnt> queue = new PriorityQueue<>(k);
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            queue.offer(new NumAndCnt(m.getKey(), m.getValue()));
        }
        for (int i = 0; i < out.length; i++) {
            out[i] = queue.poll().num;
        }
        return out;
    }

    class NumAndCnt implements Comparable {
        public Integer num;
        public Integer cnt;

        public NumAndCnt(Integer num, Integer cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Object o) {
            return ((NumAndCnt) o).cnt - this.cnt;
        }
    }
}
