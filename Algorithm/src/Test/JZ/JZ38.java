package Test.JZ;

import java.util.LinkedList;
import java.util.Queue;

/*
* 输入一棵二叉树，求该树的深度。
* 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
* */
public class JZ38 {
    //直接递归比较（效率较低）
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left,right)+1;
    }

    //BFS来判断树的最大深度(效率较高)
    public int TreeDepth_BFS(TreeNode root) {
        if (root == null) return 0;
        //树深度
        int deep = 0;
        //广度遍历的队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                TreeNode cur = queue.poll();
                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
                size -= 1;
            }
            deep += 1;
        }
        return deep;
    }
}
