package DiDi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述：
 * 给一个字符串s，你可以至多选择两个不同位置的字符进行交换（可以选择不交换，保留原串），问所有可能中字典序最小的串。
 * <p>
 * 有关字典序：对于长度相同的串a和串b，串a的字典序小于串b当且仅当存在一个位置i使得串a和串b的前i-1个字符完全相同且串a的第i个字符小于串b的第i个字符。即a1=b1,a2=b2,...ai-1=bi-1且ai<bi。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 一行一个字符串s，保证串中都为小写字母('a'~'z')。字符串长度<=200000
 * <p>
 * 输出描述
 * 输出一个串t，表示所有可能中字典序最小的串。
 * <p>
 * <p>
 * 样例输入
 * aaazbcdeadcd
 * 样例输出
 * aaaabcdezdcd
 */
public class Main01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine().trim();


        //遍历，当到达索引i时，如果后续有小于他的字符，则交换
        int len = s.length();
        StringBuilder str = new StringBuilder(s);
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != 'a') {//等于a说明无需交换
                int index = i;//用于标志后续字符中最小的字符所在的
                for (int j = i + 1; j < len; j++) {
                    if (str.charAt(j) < str.charAt(index)) {
                        index = j;
                    }
                }
                if (index != i) {
                    char tmp = str.charAt(i);
                    str.setCharAt(i, str.charAt(index));
                    str.setCharAt(index, tmp);
                    System.out.println(str.toString());
                    //直接中断
                    break;
                }
            }
        }
    }
}
