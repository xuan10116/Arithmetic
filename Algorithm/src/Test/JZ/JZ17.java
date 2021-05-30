package Test.JZ;

/*
* 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
*
* 示例:
* 输入：
* {8,8,#,9,#,2,#,5},{8,9,#,2}
* 结果：
* true
 * */
public class JZ17 {
    //答题思路：
    // 首先我们是在“大树”中找到和“小树（子结构）”根节点值相同的节点
    // 再从该节点判断是否包含这个子结构
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        if (root1.val == root2.val){
            if (judge(root1, root2))
                return true;
        }
        return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }

    //judge(root1,root2)用来判断root2是否是root1的“子结构”
    public boolean judge(TreeNode root1,TreeNode root2){
        //当root2判断完之后，说明在root1中已经存在root2这样的子结构，返回true
        if (root2 == null) return true;
        //当root2还没有判断完，而root1却已经判断完了，则root1中没能包含完root2，则返回false
        if (root1 == null) return false;
        if (root1.val == root2.val)
            return judge(root1.left, root2.left) && judge(root1.right, root2.right);
        return false;
    }
}
