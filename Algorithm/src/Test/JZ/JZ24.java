package Test.JZ;

import java.util.ArrayList;

/*
* 描述
输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
示例
输入：
    {10,5,12,4,7},22
返回值：
    [[10,5,7],[10,12]]
示例
输入：
    {10,5,12,4,7},15
返回值：
    []
*
* */
public class JZ24 {
    //将这些递归中用到的数据我们放在外面，他们呢就不会随着每一个递归产生的栈帧而变化，
    //就是说，我们在这么多的递归中使用的都是同一个路径集，和一个list来探索
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();//用来存储所有的路径
    ArrayList<Integer> list = new ArrayList<>();//存储当前遍历到的路径
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return result;
        list.add(root.val);
        //每次在路径中放入节点值的时候就更新target
        target -= root.val;
        //当当前遍历到了树的叶子节点，且target=该路径上节点值的和时将该路径添加到结果集中
        if (target == 0 && root.left == null && root.right == null)
            result.add(new ArrayList<Integer>(list));
        //递归遍历左子树
        FindPath(root.left,target);
        //递归遍历右子树
        FindPath(root.right,target);
        //当遍历完左右子树我们就开始回溯，从当前路径上删除当前节点，代表从当前节点回溯
        list.remove(list.size() - 1);
        return result;
    }
}
