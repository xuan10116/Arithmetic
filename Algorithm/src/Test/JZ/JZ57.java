package Test.JZ;

import java.util.ArrayList;

public class JZ57 {
    //方法一，根据该节点找到根节点，然后再递归遍历最后在递归的节点中找到该节点的下一节。
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //首先根据当前节点找到树根节点
        TreeLinkNode root = getRoot(pNode);
        //中序遍历树，将得到的节点都存储在list中
        ArrayList<TreeLinkNode> midResult = new ArrayList<>();
        inOrderList(root,midResult);
        //在当前列表中找到原本给出的节点，输出其在链表中的下一个节点
        int i = midResult.indexOf(pNode);
        if (i==midResult.size()-1) return null;
        return midResult.get(i+1);
    }

    public TreeLinkNode getRoot(TreeLinkNode cur){
        if (cur.next != null)
            return getRoot(cur.next);
        return cur;
    }

    public void inOrderList(TreeLinkNode node, ArrayList midlist){
        if (node == null) return;
        inOrderList(node.left,midlist);
        midlist.add(node);
        inOrderList(node.right,midlist);
    }

    //方法二，根据当前给定结点的不同情况做出不同的判断
    public TreeLinkNode GetNext2(TreeLinkNode pNode){
        //1,判断当前节点的右子节点为不为空
        if (pNode.right != null){
            //如果当前节点的右子节点不为空，那么向下探索
            TreeLinkNode pRight = pNode.right;
            //如果当前子树的左子节点为空
            while(pRight.left != null){
                pRight = pRight.left;
            }
            //那么就该子树的根节点（pRight）
            return pRight;
        }
        //2,当前节点没有右子节点，该回溯了，判断其是否是父节点的左子节点，如果是，那么就该输出该节点的父节点了
        if (pNode.next != null && pNode.next.left == pNode){
            return pNode.next;
        }
        //3,当该节点是其父节点的右子节点
        if(pNode.next != null){
            //找到其父节点
            TreeLinkNode pNext = pNode.next;
            //判断当前节点是否是其父节点的右子节点，是的话就开始回溯
            while(pNext.next != null && pNext.next.right == pNext){
                pNext = pNext.next;
            }
            //回溯之后就输出上层节点
            return pNext.next;
        }
        return null;
    }
}
