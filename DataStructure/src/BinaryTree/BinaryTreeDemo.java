package BinaryTree;

public class BinaryTreeDemo{
    public static void main(String[] args) {
        BinaryTree heros = new BinaryTree();
        HeroNode root = new HeroNode(1,"宋江");
        HeroNode node2 = new HeroNode(2,"吴用");
        HeroNode node3 = new HeroNode(3,"卢俊义");
        HeroNode node4 = new HeroNode(4,"林冲");
        HeroNode node5 = new HeroNode(5,"华荣");

        heros.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        System.out.println("proOrder:");
        heros.proOrder();

        System.out.println("midOrder:");
        heros.midOrder();

        System.out.println("afterOrder:");
        heros.afterOrder();

        System.out.println("\n proSearch:");
        HeroNode heroNode = heros.proSearch(5);
        if (heroNode!=null){
            System.out.printf("查找到的信息为： no=%d,name=%s",heroNode.getNo(),heroNode.getName());
        }else{
            System.out.println("查无此人");
        }

        System.out.println("\n midOrder:");
        HeroNode heroNode1 = heros.midSearch(5);
        if (heroNode1!=null){
            System.out.printf("查找到的信息为： no=%d,name=%s",heroNode1.getNo(),heroNode1.getName());
        }else{
            System.out.println("查无此人");
        }

        System.out.println("\n afterOrder:");
        HeroNode heroNode2 = heros.afterSearch(5);
        if (heroNode2!=null){
            System.out.printf("查找到的信息为： no=%d,name=%s",heroNode2.getNo(),heroNode2.getName());
        }else{
            System.out.println("查无此人");
        }

        System.out.println("\n 删除 五号 节点");
        heros.delNode(5);
        System.out.println("\n 删除节点后的树 前序遍历为：");
        heros.proOrder();
    }
}

class BinaryTree {
    private HeroNode root;
    public void setRoot(HeroNode root){
        this.root=root;
    }

    //前序遍历
    public void proOrder(){
        if (this.root!=null){
            root.proOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void midOrder(){
        if (this.root!=null){
            root.midOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void afterOrder(){
        if (this.root!=null){
            root.afterOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序查找
    public HeroNode proSearch(int no){
        if (root != null){
            return root.proSearch(no);
        }else{
            return null;
        }
    }
    //中序查找
    public HeroNode midSearch(int no){
        if (root!=null){
            return root.midSearch(no);
        }else{
            return null;
        }
    }
    //后续查找
    public HeroNode afterSearch(int no){
        if (root!=null){
            return root.afterSearch(no);
        }else{
            return null;
        }
    }

    //删除节点
    public void delNode(int no){
        if (root!=null){
            if(root.getNo()==no){
                root=null;
            }else{
                root.delNode(no);
            }
        }
    }
}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name, HeroNode left, HeroNode right) {
        this.no = no;
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public HeroNode(int id, String name) {
        this.no=id;
        this.name=name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name +
                '}';
    }

    //前序遍历
    public void proOrder(){
        System.out.println(this);
        if (this.left!=null) this.left.proOrder();
        if (this.right !=null) this.right.proOrder();
    }

    //中序遍历
    public void midOrder(){
        if (this.left!=null) this.left.midOrder();
        System.out.println(this);
        if (this.right!=null) this.right.midOrder();
    }

    //后续遍历
    public void afterOrder(){
        if (this.left!=null) this.left.afterOrder();
        if (this.right!=null) this.right.afterOrder();
        System.out.println(this);
    }

    //前序查找
    public HeroNode proSearch(int no){//no,是需要查找编号
        if (this.no==no) return this;
        HeroNode resNode = null;
        if (this.left!=null){
            resNode = this.left.proSearch(no);
        }
        if (resNode!=null) return resNode;

        if (this.right!=null){
            resNode = this.right.proSearch(no);
        }
        return resNode;
    }

    //中序查找
    public HeroNode midSearch(int no){

        HeroNode resNode = null;

        if (this.left!=null){
            resNode=this.left.midSearch(no);
        }
        if (resNode!=null) return resNode;
        if (this.no==no) return this;
        if (this.right!=null){
            resNode=this.right.midSearch(no);
        }
        return resNode;
    }

    //后续查找
    public HeroNode afterSearch(int no){
        HeroNode resNode = null;
        if (this.left!=null){
            resNode = this.left.afterSearch(no);
        }
        if (resNode!=null) return resNode;
        if (this.right!=null){
            resNode = this.right.afterSearch(no);
        }
        if (resNode!=null) return resNode;
        if (no==this.no) return this;
        return resNode;
    }

    //删除节点
    public void delNode(int no){
        if(this.left!=null&&this.left.no==no){
            this.left=null;
            return;
        }
        if(this.right!=null&&this.right.no==no){
            this.right=null;
            return;
        }
        if (this.left!=null){
            this.left.delNode(no);
        }
        if (this.right!=null){
            this.right.delNode(no);
        }
    }
}
