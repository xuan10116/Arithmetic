package Test.JZ;

import java.util.LinkedList;

/*
* 请实现一个函数，用来判断一棵二叉树是不是对称的。
* 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
* */
public class JZ58 {
    //我的想法，使用BFS来做，每次判断queue首尾节点的值是否相同,这个写法暂时不能通过类似于
    //{5,5,5,5,#,#,5,5,#,5}这种，利用了null的间隙形成的对称，
    boolean isSymmetrical_me(TreeNode pRoot) {
        if (pRoot == null) return true;
        if (pRoot.left == null && pRoot.right == null) return true;
        if (pRoot.left == null || pRoot.right == null) return false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot.left);
        queue.add(pRoot.right);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if ((size & 1) != 0) return false;
            for (int i = 0; i < size / 2; i++) {
                TreeNode first = queue.get(i);
                TreeNode last = queue.get(size - i - 1);
                if (first.val != last.val) return false;
            }
            while(size>0){
                TreeNode cur = queue.poll();
                queue.add(cur.left);
                //这样改可以使得{5,5,5,5,#,#,5,5,#,5}运行通过，但可能会导致死循环
                //else queue.add(new TreeNode(0));
                queue.add(cur.right);
                //else queue.add(new TreeNode(0));
                size -= 1;
            }
        }
        return true;
    }

    //剑指解法,递归，将原树root的左右子节点分成两棵树，每次都判断两棵树中不同的分支
    boolean isSymmetrical_JZ(TreeNode pRoot) {
        return pRoot == null || jude(pRoot.left,pRoot.right);
    }
    public boolean jude(TreeNode node1,TreeNode node2){
        if (node1 == null && node2 == null) return true;
        else if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;
        else return jude(node1.left, node2.right) && jude(node1.right,node2.left);
    }

    //正确的非递归解法，比我的想法优越
    boolean isSymmetrical_noR(TreeNode pRoot) {
        if (pRoot == null) return true;
        LinkedList<TreeNode> leftList = new LinkedList<>();
        LinkedList<TreeNode> rightList = new LinkedList<>();
        leftList.add(pRoot.left);
        rightList.add(pRoot.right);
        while(!leftList.isEmpty() && !rightList.isEmpty()){
            TreeNode leftNode = leftList.poll();
            TreeNode rightNode = rightList.poll();
            if (leftNode == null && rightNode == null) continue;
            if (leftNode == null || rightNode == null) return false;
            if (leftNode.val != rightNode.val) return false;
            //左子树从左往右添加节点
            leftList.add(leftNode.left);
            leftList.add(leftNode.right);
            //右子树从右往左添加节点
            rightList.add(rightNode.right);
            rightList.add(rightNode.left);
        }
        return leftList.isEmpty() && rightList.isEmpty();
    }
}
