package FuTu;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main01 {
    public static void main(String[] args) {
        int[] nums = new int[]{4045451, 400111111, 42222, 5};
        System.out.println(solve(nums));
    }

    public static String solve(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            int len = o1.length()+o2.length();
            String oo1 = o2+o1,oo2 = o1+o2;
            for (int i = 0; i < len; i++) {
                if(oo1.charAt(i)!=oo2.charAt(i)){
                    return oo1.charAt(i) - oo2.charAt(i);
                }
            }
            return 0;
        });
        for (int num : nums) {
            queue.offer(String.valueOf(num));
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}
