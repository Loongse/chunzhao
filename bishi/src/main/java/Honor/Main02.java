package Honor;

import java.util.*;

//买水果：套餐可以分为给出的和单买一种水果类型。
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<List<Integer>, Integer> map = new HashMap<>();//用于存放套餐-价格键值对
        List<Integer> rel = new ArrayList<>();//目标水果数
        String[] rels = sc.nextLine().trim().split(" ");//第一行表示目标
        String[] price = sc.nextLine().trim().split(" ");//单价集合
        List<Integer> list = new ArrayList<>(rels.length);//用于存放套餐信息
        for (int i = 0; i < rels.length; i++) {
            rel.add(Integer.parseInt(rels[i]));
            //把单价也看成一个套餐
            list.add(i, 1);
            map.put(new ArrayList(list), Integer.parseInt(price[i]));
        }
        while (sc.hasNext()) {
            //读取正常套餐
            String[] s = sc.nextLine().trim().split(" ");
            list = new ArrayList<>(rels.length);
            for (String value : s) {
                list.add(Integer.parseInt(value));
            }
            map.put(list, Integer.parseInt(s[s.length - 1]));
        }
        //打印结果
        System.out.println(minPrice(rel, map));
    }

    private static int minPrice(List<Integer> rel, Map<List<Integer>, Integer> map) {
        return 11;
    }
}
