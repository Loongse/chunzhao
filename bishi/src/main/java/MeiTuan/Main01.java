package MeiTuan;

import java.util.Scanner;

/**
 * 小美最近在学习操作系统。
 * <p>
 * 流是操作系统中一个重要的概念。在 Linux 操作系统中，/dev/random 和 /dev/urandom 是两个重要的设备，它们可以提供永不为空的随机字节数据流。
 * <p>
 * 小美自己也实现了一个类似于 /dev/random 的设备 /dev/crandom，但是它只能提供预先设定好但循环不断的某个小写字母排列。例如预先设定的字符串为 abcdefgh...xyz，那么这个设备会提供永不为空的字符串流 abcdefgh...xyzabcdefg...xyzabc...。
 * <p>
 * 小美想利用这个设备生成一段文字，但她想知道恰好生成完这段文字时，浪费了这个流的多少个字符。
 * <p>
 * 样例说明
 * <p>
 * 拿取生成流中字母的情况如下，拿取的字母用下划线表示。
 * <p>
 * abcde...lmn...def...hij...stu..zab...mno...
 * <p>
 * 在生成好最后一个 n 的时候，浪费了没有标下划线的 59 个字符
 */
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //预设字母排列
        String mode = sc.nextLine().trim();
        //想要生成的字符串
        String res = sc.nextLine().trim();
        char[] chars = res.toCharArray();
        int len = mode.length();//模板字符串的长度
        int resLen = chars.length;//目标串长度
        int[] index = new int[resLen];//用于存储res中相对字符在mode中的位置
        int sum = index[0] = mode.indexOf(chars[0]);//初始化总和
        for (int i = 1; i < resLen; i++) {
            index[i] = mode.indexOf(chars[i]);
            if (index[i] > index[i - 1]) {
                //只需要往后即可找到
                sum += (index[i] - index[i - 1] - 1);
            } else if (index[i] == index[i - 1]) {
                //需要循环一圈
                sum += (len - 1);
            } else {
                //需要循环一圈后再走
                sum += (len - index[i - 1] + index[i] - 1);
            }
        }
        System.out.println(sum);
    }
}
