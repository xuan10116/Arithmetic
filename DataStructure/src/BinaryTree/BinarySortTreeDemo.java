package BinaryTree;

/**
 * BST：可称为Binary Sort Tree或者Binary Search Tree
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9,0};
        BinarySortTree binarySortTree = new BinarySortTree();

        //循环的添加节点到二叉排序树中
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        //中序遍历二叉排序树
        System.out.println("midOrder()");
        binarySortTree.midOrder();

        System.out.println("targetNode存在右子树");
        //测试删除
        binarySortTree.delNode(7);
        binarySortTree.midOrder();
    }
}

//二叉排序树
class BinarySortTree{
    private Node root;
    //添加节点的方法
    public void add(Node node){
        if (this.root==null){
            root=node;
        }else{
            root.add(node);
        }
    }
    //中序遍历,中序遍历二叉排序树为升序排序
    public void midOrder(){
        if (this.root!=null){
            root.midOrder();
        }else{
            System.out.println("BST is null !!!");
        }
    }

    //编写方法：
    //1，返回的以 node 为根节点的二叉排序树的最小节点的值
    //2，删除node为根节点的二叉排序树的最小节点
    /**
     *
     * @param node 传入的节点（当作二叉排序树的根节点）
     * @return 返回 以node 为根节点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node node){
        Node target = node;
        //循环的查找左子节点，直至找到最小值
        while(target.left != null){
            target = target.left;
        }
        //此时target就指向了最小节点
        //删除最小节点
        delNode(target.val);
        return target.val;
    }


    //查找要删除的节点
    public Node search(int value){
        if (root==null) return null;
        else return this.root.search(value);
    }
    //查找要删除的节点的父节点
    public Node searchParent(int value){
        if (root==null) return  null;
        else return root.searchParent(value);
    }
    //删除节点
    public void delNode(int value){
        if (root==null) return;
        else{
            //1,需要先去找到待删除的节点，targetNode
            Node targetNode = search(value);
            //如果没有找到要删除的节点
            if(targetNode==null) return;
            //如果步骤一找到了待删除的节点，并且当前树只有一个节点，那表明，我们要删除的就是根节点
            if (root.left==null && root.right== null){
                root = null;
                return;
            }

            //2，查找targetNode的父节点
            Node parent = searchParent(value);
            //如果要删除的节点是叶子节点
            if (targetNode.left==null && targetNode.right==null){
                //判断targetNode是父节点的左子节点，还是右子节点
                if (parent.left!=null && parent.left.val==value) parent.left=null;
                else if (parent.right!=null && parent.right.val==value) parent.right=null;
            }
            //如果删除的节点有两棵子树
            else if(targetNode.left!=null && targetNode.right!=null){
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.val = minVal;
            }
            //如果删除的节点有一棵子树，不确定是左子树还是右子树
            else{
                //如果要删除的节点有左子节点
                if (targetNode.left!=null){
                    //如果targetNode是parent的左子节点
                    if (parent != null){
                        if(parent.left.val==value){
                            parent.left=targetNode.left;
                        }else{//targetNode是parent的右子节点
                            parent.right = targetNode.left;
                        }
                    }else{
                        root = targetNode.left;
                    }
                }else{//如果要删除的节点有右子节点
                    if (parent!=null){
                        //如果targetNode是parent的左子节点
                        if (parent.left.val==value){
                            parent.left=targetNode.right;
                        }else{
                            //如果targetNode是parent的右子节点
                            if (parent.right.val==value){
                                parent.right=targetNode.right;
                            }
                        }
                    }else{
                        root = targetNode.right;
                    }
                }
            }
        }
    }
}

//树节点
class Node{
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    //添加节点的方法
    //递归的添加节点，注意需要满足二叉排序树的要求
    public void add(Node node){
        if (node == null) return;

        //判断传入的节点的值和当前子树的根节点的值的大小关系
            //待添加的节点的值小于当前节点的值
        if(node.val < this.val){
            //如果当前节点的左子树为空，则直接将待插入节点作为当前节点的左子树
            if (this.left == null){
                this.left = node;
            }else{
                //否则递归的对当前节点的左子树进行同样的方法
                this.left.add(node);
            }
        }else{
            //待添加的节点的值大于或等于当前节点的值
            //如果当前右子树为空，则将待插入节点直接作为右子树
            if (this.right==null){
                this.right=node;
            }else{
                //否则递归的对当前节点的右子树进行同样的方法
                this.right.add(node);
            }

        }
    }

    //中序遍历
    public void midOrder(){
        if (this.left!=null) this.left.midOrder();
        System.out.println(this);
        if (this.right!=null) this.right.midOrder();
    }

    //查找待删除节点
    public Node search(int value){
        //如果查找的值就是当前节点的值，那么直接返回该节点
        if (value == this.val) return this;
        //如果查找的值小于当前节点的值，且当前节点的左子树不为空，那么对当前节点的左子树进行递归查找
        else if (this.left!=null && value<this.val){
            return this.left.search(value);
        }
        //如果查找的值大于当前节点的值，且当前节点的右子树不为空，那么对当前节点的左子树进行递归查找
        else if (this.right!=null && value>this.val){
            return this.right.search(value);
        }
        //可能由于该节点左右节点可能为空的情况下，导致的没有找到该删除的节点，那么返回null，表示该排序二叉树中不存在该节点
        else return null;
    }

    //查找待删除节点的父节点
    public Node searchParent(int value){
        //如果当前节点就是要删除的节点的父节点，则返回
        if (this.left!=null && this.left.val==value || this.right!=null && this.right.val==value)
            return this;
        else{
            //如果查找的值小于当前节点的值，并且当前节点的左子节点不为空,那么向当前节点的左子节点进行递归查找
            if (this.left!=null && value<this.val) return this.left.searchParent(value);
            //否则，如果查找的值大于等于当前节点的值，并且当前节点的右子节点不为空，那么向当前右子节点进行递归查找
            else if (this.right!=null && value>=this.val) return this.right.searchParent(value);
            //可能由于该节点左右节点可能为空的情况下，导致的没有找到该删除节点的父节点，那么返回null，表示该排序二叉树中不存在该节点
            else return null;
        }
    }
}