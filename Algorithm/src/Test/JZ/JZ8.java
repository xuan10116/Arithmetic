package Test.JZ;
/*
* 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
* 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
* */
public class JZ8 {
    public int jumpFloor(int target) {
        if (target==0) return 0;
        if (target<=2) return target;
        int n=0;
        int pre_1 = 2;
        int pre_2 = 1;
        for (int i=3;i<=target;i++){
            n= pre_1+ pre_2;
            pre_2 = pre_1;
            pre_1 = n;
        }
        return n;
    }
}
