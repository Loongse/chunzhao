package HaoWeiLai;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(solution(s, t));
    }

    public static String solution(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        Set<Character> set = charOfT(t);//获取t中存在的所有字符
        Set<Character> tSet = new HashSet<>();
        int len = s.length();
        int max_begin = 0, max_end = 0;
        int begin = 0, end = 0;
        int max = Integer.MAX_VALUE;//用于更新
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                //开始读取
                begin = i;
                for (int j = i; j < len; j++) {
                    if(set.contains(s.charAt(j))){
                        tSet.add(s.charAt(j));
                        set.remove(s.charAt(j));
                    }
                    if (set.isEmpty()) {
                        //保存末尾位置
                        end = j;
                        if (max > (end - begin)) {
                            //需要更新最短匹配串
                            max = end - begin;
                            max_begin = begin;
                            max_end = end;
                        }
                    }
                }
            }
            set.addAll(tSet);
            tSet.clear();
        }
        if(max!=Integer.MAX_VALUE){
            //存在
            return s.substring(max_begin,max_end+1);
        }else{
            //不存在
            return "";
        }
    }

    private static Set<Character> charOfT(String t) {
        Set<Character> set = new HashSet<>();
        int len = t.length();
        for (int i = 0; i < len; i++) {
            set.add(t.charAt(i));
        }
        return set;
    }
}
