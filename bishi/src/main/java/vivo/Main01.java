package vivo;

import java.util.*;

public class Main01 {
    public static void main(String[] args) {

    }
}
class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 编译顺序
     * @param input string字符串
     * @return string字符串
     */
    public String compileSeq (String input) {
        // write code here
        //使用优先队列完成
        String[] depen = input.split(",");//分割依赖
        //存入键值对：i号文件依赖j号文件。
        List<Depen> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < depen.length; i++) {
            int depenTo = Integer.parseInt(depen[i]);
            if(depenTo == -1){
                //放入队列
                pq.offer(i);
            }else{
                list.add(new Depen(i,depenTo));
            }
        }
        StringBuilder s = new StringBuilder();
        while (!pq.isEmpty()){
            int to = pq.poll();
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).to == to){
                    //删除该项且放入到队列
                    pq.offer(list.get(i).one);
                    list.remove(i--);
                }
            }
            s.append(to).append(",");
        }
        return s.substring(0,s.length()-1);
    }
    class Depen{
        public int one;
        public int to;
        public Depen(int one,int to){
            this.one = one;
            this.to = to;
        }
    }
}
