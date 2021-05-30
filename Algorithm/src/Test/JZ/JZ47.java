package Test.JZ;

import java.util.Map;

/*
*求1+2+3+...+n.
*
*要求
*   不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
* */
public class JZ47 {
    //解决思路：
    //  使用逻辑与 && 的特性实现递归或终止
    public int Sum_Solution(int n) {
        //相当于判断  n大于一吗？
        //  大于就继续
        //      (n+=Sum_Solution(n-1))
        //  否则直接短路
        boolean anx = (n>1) && ((n+=Sum_Solution(n-1)))>0;
        return n;
    }

    //投机取巧
    //  直接使用等差数列求和公式
    //  数列为 1，2，3，4...n,等差d=1
    //  sum = (1+n)*n/2 = (n+n^2)/2;
    public int Sum_Solution_2(int n){
        //相当于计算 分子
        int sum =(int) Math.pow(n,2)+n;
        //相当于除二
        return sum>>1;
    }
}
