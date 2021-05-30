package Test.JZ;

import java.util.ArrayList;
import java.util.List;

/*
* 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
* 要求不能创建任何新的结点，只能调整树中结点指针的指向。
* */
public class JZ26 {

    //大神解法，一次中序遍历中完成节点指针的修改,
    //使用一个指针指向每次遍历到的节点。
    //下次中序遍历到的节点的前驱便是此节点指向的节点，而此节点的后继是此时遍历到的节点
    private TreeNode lastNodeList = null;
    public void inOrderConvert(TreeNode root){
        if (root == null) return ;
        inOrderConvert(root.left);
        root.left = lastNodeList;
        if (lastNodeList != null) lastNodeList.right = root;
        lastNodeList = root;
        inOrderConvert(root.right);
    }
    public  TreeNode Convert1(TreeNode pRootOfTree){
        inOrderConvert(pRootOfTree);
        //寻找链表头节点，大神是从lastNodeList.left开始向回找的，下面有人优化建议从pRootOfTree节点开始向回找
        while(pRootOfTree != null && pRootOfTree.left != null)
            pRootOfTree = pRootOfTree.left;
        return pRootOfTree;
    }

    //投机方法
    //不创建节点，而是直接创建一个队列来存储中序遍历的结果。
    //最后根据列表中的元素重新设置节点的指针指向
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        ArrayList<TreeNode> inresult = new ArrayList<>();
        inorder(inresult,pRootOfTree);
        TreeNode head = inresult.get(0);
        TreeNode ptr = head;
        TreeNode cur = null;
        head.left = null;
        for (int i=1;i<inresult.size();i++){
            cur = inresult.get(i);
            ptr.right = inresult.get(i);
            cur.left = ptr;
            ptr = ptr.right;
        }
        return head;
    }

    public void inorder(List arrayList,TreeNode root){
        if (root == null) return ;
        inorder(arrayList,root.left);
        arrayList.add(root);
        inorder(arrayList, root.right);
    }
}
