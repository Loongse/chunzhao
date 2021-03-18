package OPPO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main02 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型ArrayList<ArrayList <>>
     */
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> n = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(int[] nums) {
        // write code here
        for (int num : nums) {
            n.add(num);
        }
        dfs(0);
        return res;
    }

    void dfs(int x){
        if(x == n.size()-1){
            //添加排列
            res.add(new ArrayList<>(n));
            return ;//回溯回去
        }
        for (int i = x; i < n.size(); i++) {
            Collections.swap(n,i,x);
            dfs(x+1);
            Collections.swap(n,i,x);
        }
    }
}
