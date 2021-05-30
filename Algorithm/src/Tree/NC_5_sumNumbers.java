package Tree;

public class NC_5_sumNumbers {
    public int sumNumbers(TreeNode root){
        int sum=0;
        if (root == null) return sum;

        return sumNumberAll(root,sum);
    }

    public int sumNumberAll(TreeNode root,int sum){
        if (root==null) return 0;//这块注意，向上传的是0。
        sum = sum*10 + root.val;
        if(root.left==null && root.right==null) return sum;
        return sumNumberAll(root.left,sum)+sumNumberAll(root.right,sum);
    }
}
