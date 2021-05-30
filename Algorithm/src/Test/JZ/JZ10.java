package Test.JZ;

/*
* 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
* 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，从同一个方向看总共有多少种不同的方法？
*
* 思路分析，其实和跳台阶问题一样，f(n)=f(n-1)+f(n-2)
* */
public class JZ10 {
    public int rectCover(int target) {
        if (target<=0) return 0;
        if (target<=2) return target;
        int pre_1 = 1;
        int pre_2 = 2;
        int n = 0;
        for(int i=3;i<=target;i++){
            n=pre_1+pre_2;
            pre_1 = pre_2;
            pre_2 = n;
        }
        return n;
    }
}
