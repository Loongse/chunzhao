package OPPO;

import util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main03 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param arrLists ListNode类一维数组
     * @return ListNode类
     */
    public ListNode sortArrayLists (ListNode[] arrLists) {
        // write code here
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o2.val - o1.val;
            }
        });
        for (ListNode list : arrLists) {
            while(list != null){
                queue.offer(list);
                list = list.next;
            }
        }
        ListNode vir = new ListNode(0);
        ListNode head = vir;
        while (!queue.isEmpty()){
            head.next
                     = queue.poll();
            head = head.next;
        }
        head.next = null;
        return vir.next;
    }
}
