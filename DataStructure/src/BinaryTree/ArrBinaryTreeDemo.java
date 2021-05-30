package BinaryTree;

/**
 * 顺序存储二叉树的特点：
 * 1），通常只考虑  完全二叉树
 * 2），第n个元素的左子节点为2*n+1
 * 3），第n个元素的右子节点为2*n+2
 * 4），第n个元素的夫节点为（n-1）/2
 * （n表示数组中的索引）
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        System.out.println("proOrder:");
        arrBinaryTree.proOrder();
        System.out.println("midOrder:");
        arrBinaryTree.midOrder();
        System.out.println("afterOrder:");
        arrBinaryTree.afterOrder();
    }
}

class ArrBinaryTree{
    int[] ArrTree;

    public ArrBinaryTree(int[] arrTree) {
        ArrTree = arrTree;
    }

    public void proOrder(int no){
        int num = ArrTree.length;
        if (num!=0){
            if (num<no){
                return;
            }
            System.out.println(ArrTree[no]);
            if (2*no+1<num){
                proOrder(2*no+1);
            }
            if (2*no+2<num){
                proOrder(2*no+2);
            }
        }
    }

    public void midOrder(int no){
        int num=ArrTree.length;
        if (num!=0){
            if (num<=no){
                return;
            }
            if (2*no+1<num){
                midOrder(2*no+1);
            }
            System.out.println(ArrTree[no]);
            if (2*no+2<num){
                midOrder(2*no+2);
            }
        }
    }
    public void afterOrder(int no){
        int num=ArrTree.length;
        if (num!=0){
            if (num<=no){
                return;
            }
            if (2*no+1<num){
                afterOrder(2*no+1);
            }
            if (2*no+2<num){
                afterOrder(2*no+2);
            }
            System.out.println(ArrTree[no]);
        }
    }

    public void proOrder(){
        this.proOrder(0);
    }

    public void midOrder(){
        this.midOrder(0);
    }

    public void afterOrder(){
        this.afterOrder(0);
    }
}
