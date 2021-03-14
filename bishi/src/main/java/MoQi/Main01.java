package MoQi;

import util.ListNode;

//返回两个链表相加的值
public class Main01 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode vir = new ListNode(0);
        vir.next = l1;
        ListNode node = l1;
        int sum, cnt = 0;
        while (l1 != null && l2 != null) {
            sum = cnt + l1.val + l2.val;
            cnt = sum / 10;
            sum = sum % 10;
            l1.val = sum;
            node = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null){
            while (l1!=null){
                sum = cnt +l1.val;
                cnt = sum /10;
                sum = sum %10;
                l1.val = sum;
                node = l1;
                l1 = l1.next;
            }
        }else{
            node.next = l2;
            while (l2!=null){
                sum = cnt +l2.val;
                cnt = sum /10;
                sum = sum %10;
                l2.val = sum;
                node = l2;
                l2 = l2.next;
            }
        }
        if (cnt != 0) {
            node.next = new ListNode(cnt);
        }
        return vir.next;
    }
}

