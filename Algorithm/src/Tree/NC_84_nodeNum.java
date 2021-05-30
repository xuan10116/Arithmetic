package Tree;

public class NC_84_nodeNum {
    public int nodeNum(TreeNode root){
        if(root == null) return 0;
        return nodeNum(root.left)+nodeNum(root.right)+1;
    }
}
