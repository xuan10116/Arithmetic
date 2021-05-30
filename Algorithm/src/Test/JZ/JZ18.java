package Test.JZ;

import java.util.LinkedList;
import java.util.Queue;

/*
* 操作给定的二叉树，将其变换为源二叉树的镜像。
比如：    源二叉树
            8
           /  \
          6   10
         / \  / \
        5  7 9 11
        镜像二叉树
            8
           /  \
          10   6
         / \  / \
        11 9 7  5

*
  输入：
    {8,6,10,5,7,9,11}
  返回值：
    {8,10,6,11,9,7,5}

* */
public class JZ18 {
    //解法一：首先我们使用，树的BFS遍历来调整树的结构（效率较高）
    public TreeNode Mirror (TreeNode pRoot) {
        if (pRoot == null) return null;
        //首先我们需要一个结构来存储已经遍历过的结点的子节点
        Queue<TreeNode> nodes = new LinkedList<>();
        //首先我们需要将树的根结点放进去
        nodes.add(pRoot);
        //然后进入正式的BFS
        while(!nodes.isEmpty()){
            //从队列中移除队首元素并返回
            TreeNode cur = nodes.poll();
            //开始交换该节点的左右子节点,就是一个简单的两个值的交换
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            //交换完毕将这两个节点再放入队列中。
            //首先执行判空操作，为空就不再放入队列
            if (cur.left != null) nodes.add(cur.left);
            if (cur.right != null) nodes.add(cur.right);
        }
        return pRoot;
    }

    //解法二：递归的方式(太慢了)，每次递归我们就交换当前节点的左右节点，然后递归执行
    public TreeNode Mirror2 (TreeNode pRoot) {
        if (pRoot == null) return null;
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        Mirror2(pRoot.left);
        Mirror2(pRoot.right);
        return pRoot;
    }
}
