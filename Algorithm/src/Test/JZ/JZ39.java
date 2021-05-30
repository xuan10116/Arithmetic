package Test.JZ;
/*
* 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
  在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
  平衡二叉树（Balanced Binary Tree）
  具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
* */
public class JZ39 {
    //直接借助我们的判断树深度的函数，对根节点左右子树的高度差取绝对值，当该值小于等于一，则符合，否则则不符合
    public boolean IsBalanced_Solution(TreeNode root) {
        JZ38 jz38 = new JZ38();
        return Math.abs(jz38.TreeDepth_BFS(root.left)-jz38.TreeDepth_BFS(root.right))<=1;
    }

    //较为专业的，先判断根节点的左右两棵子树是否符合要求，再逐步细化，判断子树下的子树。
    public boolean IsBalanced_Solution_2(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }
        return IsBalanced_Solution_2(root.left) && IsBalanced_Solution_2(root.right);
    }
    public int getHeight(TreeNode root){
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.left);
        return 1+(Math.max(leftHeight, rightHeight));
    }
}
