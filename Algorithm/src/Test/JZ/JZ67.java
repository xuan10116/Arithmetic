package Test.JZ;

import java.util.Enumeration;

/*
* 给你一根长度为n的绳子，请把绳子剪成"整数"长的m段（m、n都是整数，n>1并且"m>1"，m<=n），
* 每段绳子的长度记为k[1],...,k[m]。
* 请问k[1]x...xk[m]可能的最大乘积是多少
*
* 我们可以分析，
* 该问题存在重叠子问题和最优子结构（当然我们可以直接使用动态规划）
*
* 有：
* 当n==2,f(2) = 1
* 当n==3,f(3) = 2
* 当n>=4,进入递归：
*     当 n<=4 ,f(n) = n;
*     当 n>4,  f(n) = i * f(n-i)
*              max = ( max , i * f (n-i) )
* */
public class JZ67 {
    //暴力解：只使用递归(算法复杂度太大，不能通过)
    public int cutRope1(int target) {
        //题目要求：至少分为两段,且绳长至少为2
        if (target == 2) return 1;
        if (target == 3) return 2;
        return backTrack(target);
    }
    public int backTrack(int n){
        if(n <= 4){
            return n;
        }
        int ret = 0;
        for (int i = 2; i < n; i++) {
            ret = Math.max(ret,i * backTrack(n-i));
        }
        return ret;
    }

    //带备忘录的递归解
    public int cutRope2(int target) {
        if (target == 2) return 1;
        if (target == 3) return 2;
        //备忘录（dp数组）
        int[] result = new int[target+1];

        return backTrack2(target,result);
    }
    public int backTrack2(int n,int[] result){
        if (n<=4){
            return n;
        }
        //在计算前先查找当前dp数组中是否有记录
        if (result[n] != 0){
            return result[n];
        }
        //递归计算部分
        int ret = 0;
        for(int i=1;i<n;++i){
            ret = Math.max(ret,backTrack2(n,result));
        }
        //返回dp数组中记录的值。
        return result[n] = ret;
    }

    //带备忘录的迭代解
    public int cutRope3(int target) {
        if (target == 2) return 1;
        if (target == 3) return 2;

        int[] result = new int[target+1];
        for (int i = 2; i<=4; i++) result[i] = i;
        for (int i =5; i <= target;i++){
            for (int j=2;j<i;j++){
                result[i] = Math.max(result[i],j * result[i-j]);
            }
        }
        return result[target];
    }
}
