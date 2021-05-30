package Test.JZ;
/*
描述
    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
    如果是则返回true,否则返回false。
    假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜素树）
示例
输入：
    [4,8,6,12,16,14,10]
返回值：
    true
* */
public class JZ23 {
    //采用分治法的思想
    // 后序遍历：
    // 序列中的数据必然是（左子树）（右子树）（根）
    // 正常的BST后序遍历序列根结点的值肯定大于左子树，而小于右子树
    // 我们根据给出的序列中最后一个值，作为根节点划分序列，然后再递归的在划分出的子序列中再划分，以此验证
    // 则从数组第一个元素开始寻找比该根大的元素，判断是否左半边大于他，右半边小于他
    // 然后递归判断下一个子数组，直到数组长度为一才返回
    public boolean VerifySequenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return judge(sequence,0,sequence.length-1);
    }

    //递归的检验根节点左子树是否小于根节点，右子树是否大于根节点
    private boolean judge(int[] sequence,int start,int end){
        if (start >= end) return true;
        int i = end;
        //我们从右向左划分，即我们先找到右子树的序列
        //右子树中的元素应当比根节点大，我们以此为根据来确定右子树的边界
        while(i >= start && sequence[i] >= sequence[end]){
            i--;
        }
        //退出while循环之后，则判断出右子树序列的边界是（i+1）因为i处的节点值已经小于根节点，所以i就是左子树的边界
        /*
        //若只进行对右子序列的判断i已经小于0了，那么说明当前树只有右子树
        if (i<0) return true;//难道不需要判断右子树序列是否符合要求？神奇的是我改为return judge(sequence,i+1,end-1)竟然无差异
        */
        //我们再再划分出的左子树序列中判断
        for (int j=i;j >= start;j--){
            //如果左子树序列中有元素大于根节点元素，那么表示序列不符合规则，直接返回false。
            if (sequence[j] > sequence[end]) return false;
        }
        //我们若能完整的验证完当前序列，那么我们再递归的去检验所划分出来的子序列中的情况
        // 左子树序列【start，i】，右子树序列【i+1，end-1】，end是我们当前根节点的索引，end-1就是右子树的边界
        return judge(sequence,start,i) && judge(sequence, i+1, end-1);
    }
}
