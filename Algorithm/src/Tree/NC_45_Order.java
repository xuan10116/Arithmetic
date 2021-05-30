package Tree;

public class NC_45_Order {

    public int[][] threeOrders(TreeNode root){
        int[][] result = new int[3][getSize(root)];
        order(result,root);
        return result;
    }
    //在外部定义前中后三种遍历当前已遍历的个数。
    int i1=0;
    int i2=0;
    int i3=0;
    public void order(int[][] result,TreeNode root){
        if (root == null) return;
        result[0][i1++] = root.val;
        order(result,root.left);
        result[1][i2++] = root.val;
        order(result,root.right);
        result[2][i3++] = root.val;
    }


    public int getSize(TreeNode root){
        if (root == null) return 0;
        return getSize(root.left)+getSize(root.right)+1;
    }
}