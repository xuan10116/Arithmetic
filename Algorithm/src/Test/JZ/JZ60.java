package Test.JZ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
*从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
*
* 相当于层序遍历二叉树，并将每一层的结果都存储起来
* */
public class JZ60 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (pRoot == null) return arrayLists;
        if (pRoot != null && pRoot.left == null && pRoot.right == null) {
            ArrayList<Integer> onlyRoot = new ArrayList<>();
            onlyRoot.add(pRoot.val);
            arrayLists.add(onlyRoot);
            return arrayLists;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(pRoot);

        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode now = q.poll();
                ans.add(now.val);
                if (now.left != null) q.add(now.left);
                if (now.right != null) q.add(now.right);
            }
            arrayLists.add(ans);
        }
        return arrayLists;
    }
}
