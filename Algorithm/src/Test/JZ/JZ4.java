package Test.JZ;


/*
*
描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
* 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
示例1
输入：
[1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
复制
返回值：
{1,2,5,3,4,6,7}
* */
public class JZ4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0) return null;

        return getRootNode(pre,0,pre.length-1,in,0,in.length-1);
    }

    public TreeNode getRootNode(int[] pre,int preFrom,int preTo,int[] in,int inFrom,int inTo){

        if(preFrom>preTo || inFrom>inTo){
            return null;
        }

        //当前子树的根节点
        TreeNode root = new TreeNode(pre[preFrom]);

        for (int i=inFrom;i<=inTo;i++) {
            if (pre[preFrom] == in[i]) {
                root.left=getRootNode(pre,preFrom+1,i-inFrom+preFrom,in,inFrom,i-1);
                root.right=getRootNode(pre,preFrom+i-inFrom+1,preTo,in,i+1,inTo);
            }
        }

        return root;
    }
}

