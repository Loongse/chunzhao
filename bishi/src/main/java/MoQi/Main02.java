package MoQi;


import util.TreeNode;

//合并两颗二叉树，空的用另一个树节点代替，都存在则相加
public class Main02 {
    public static void main(String[] args) {

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // write code here
        if (t1 == null && t2 == null) return null;
        else if (t1 == null) return t2;
        else if (t2 == null) return t1;
        else {
            t1.val = t1.val+t2.val;
            t1.left = mergeTrees(t1.left,t2.left);
            t1.right = mergeTrees(t1.right,t2.right);
            return t1;
        }
    }
}
