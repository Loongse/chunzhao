package MeiTuan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小团现在有两个等大的多重集合（与集合的区别仅是在可以在集合中出现重复元素）A 和 B。她现在想让 A 集合与 B 集合相等。她会先选择一个非负整数 x，然后让 A 集合中的所有数都加上 x 并对 m 取模。也就是说，对于 A 中的全部元素 a，都把 a 变成 (a + x) mod m。
 * <p>
 * 她想知道这个最小的 x 是多少，才能使经过变换后 A = B。并且她保证至少存在一个满足条件的 x。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 第一行两个正整数 n, m，n 表示 A, B 两集合分别有 n 个元素；
 * <p>
 * 第二行 n 个非负整数 ai，表示 A 多重集。
 * <p>
 * 第三行 n 个非负整数 bi，表示 B 多重集。
 * <p>
 * 1 ≤ n ≤ 2000, 1 ≤ m ≤ 109, 0 ≤ ai , bi < m。
 * <p>
 * 输出描述
 * 输出一个非负整数，表示最小的 x 值。
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        String strA = sc.nextLine();
        String strB = sc.nextLine();
        //因为确认存在X满足条件，而a+x) mod m < m，所以B中的元素都小于m，所以先排序操作
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = strA.charAt(i) % m;
            B[i] = strB.charAt(i);
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int maxSub = 0;
        for (int i = 0; i < n; i++) {
            int num = B[i] - A[i];//负数：A[i]只需要+小于m的数字即可 正数：本身
            //num需要与m取余操作
            num = num % m;
            maxSub = Math.max((num < 0 ? (m + num) : num), maxSub);
        }
        System.out.println(maxSub);
    }
}
