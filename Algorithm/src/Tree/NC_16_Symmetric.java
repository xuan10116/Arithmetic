package Tree;

public class NC_16_Symmetric {
    public boolean isSymmetric(TreeNode root){
        return isSymmetricNode(root,root);
    }

    public boolean isSymmetricNode(TreeNode root1,TreeNode root2){
        //两个节点都走到末尾了
        if (root1==null&&root2==null) return true;
        //两方只有一方走到结尾了，代表两者不一样
        if (root1==null||root2==null) return false;
        //如果两方都没走到结尾，判断当前值，不一样就返回false
        if (root1.val != root2.val) return false;
        //当前两方的节点值一样，继续递归。
        return isSymmetricNode(root1.left,root2.right) && isSymmetricNode(root1.right,root2.left);

    }
}
