package Tree;

import java.util.ArrayList;

class TreeNode{
    int val=0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode() {
    }
}

//层序遍历二叉树
public class NC_15_levelOrder {
    //解法
    public ArrayList<ArrayList<Integer>> solution(TreeNode root){
        //用来存放每一层的遍历结果
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

        if (root == null) return null;
        //该顺序表用来存储当前层当前还未遍历的节点
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        //首先，将根节点放入
        arrayList.add(root);
        while(!arrayList.isEmpty()){
            int s = arrayList.size();
            //建立一个顺序表，用来存放每层节点值的遍历结果
            ArrayList<Integer> nList = new ArrayList<>();
            for (int i=0;i<s;i++){
                //获取每次开始遍历的根节点
                TreeNode t = arrayList.get(0);
                //将该结点的值存入nList
                nList.add(t.val);
                //如果该节点有左右节点，那么将组右节点也放入arrayList
                if (t.left != null) arrayList.add(t.left);
                if (t.right != null) arrayList.add(t.right);
                //遍历完此节点的左右节点，将该节点移除
                arrayList.remove(0);
            }
            //将该层的遍历结果放入arrayLists
            arrayLists.add(nList);
        }

        return arrayLists;
    }
}
