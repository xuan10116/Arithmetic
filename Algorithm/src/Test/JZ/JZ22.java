package Test.JZ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
*
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
示例
输入：
    {5,4,#,3,#,2,#,1}
返回值：
    [5,4,3,2,1]

* */
public class JZ22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()){
            TreeNode cur = nodes.poll();
            result.add(cur.val);
            if (cur.left != null) nodes.add(cur.left);
            if (cur.right != null) nodes.add(cur.right);
        }
        return result;
    }
}
