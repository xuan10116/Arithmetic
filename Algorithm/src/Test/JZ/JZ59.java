package Test.JZ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JZ59 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (pRoot == null) return arrayLists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        //层序遍历并保存每层遍历的结果
        while(!queue.isEmpty()){
            ArrayList<Integer> integers = new ArrayList<>();
            int size = queue.size();
            while(size>0){
                TreeNode nodes = queue.poll();
                if (nodes.left != null) queue.add(nodes.left);
                if (nodes.right != null) queue.add(nodes.right);
                integers.add(nodes.val);
                size -= 1;
            }
            arrayLists.add(integers);
        }
        //反转奇数层，从0层开始
        for (int i=1;i<arrayLists.size();i+=2){
            resArrList(arrayLists.get(i));
        }

        return arrayLists;
    }

    public void resArrList(ArrayList<Integer> integers){
        int index = integers.size()-1;
        int temp = 0;
        for (int i=0;i<integers.size()/2;i++){
            temp = integers.get(index-i);
            integers.set(index-i,integers.get(i));
            integers.set(i,temp);
        }
    }
}
