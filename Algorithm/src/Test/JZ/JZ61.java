package Test.JZ;
/*
描述
请实现两个函数，分别用来序列化和反序列化二叉树

二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。

二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。

例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
示例1
输入：
{8,6,10,5,7,9,11}
返回值：
{8,6,10,5,7,9,11}
* */
public class JZ61 {
    //序号index
    int index =-1;
    String Serialize(TreeNode root) {
        //当该节点为空时表示我们已经探索到了一个叶子节点，用"#"表示
        if (root == null)
            return"#";
        else
            //序列元素之间用“,”作为分隔
            return root.val+","+Serialize(root.left)+","+Serialize(root.right);
    }
    TreeNode Deserialize(String str) {
        //将序列化之后的序列用“,”作为分隔符split为数组
        String[] s = str.split(",");
        //索引每次加一
        index++;
        int len = s.length;
        if (index > len) return null;
        TreeNode treeNode = null;
        //不是叶子节点，继续走
        if (!s[index].equals("#")){
            treeNode = new TreeNode(Integer.parseInt(s[index]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
        }
        //是叶子节点则退出递归
        return treeNode;
    }
}
