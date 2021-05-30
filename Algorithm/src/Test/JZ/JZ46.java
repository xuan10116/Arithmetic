package Test.JZ;

import java.util.ArrayList;

/*
* 相当于一个约瑟夫环的问题
*
* 给定一个由[0...n-1]构成的数组，第一次从0开始数m个数，然后删除，
* 以后每次都从删除的数下一个位置开始数m个数，然后删除，直到剩余一个数字，找出那个数字。
* */
public class JZ46 {
    /**
     *
     * 递推公式
     * f[1]=0;
     * f[i]=(f[i-1]+m)%i;  (i>1)
     * @param n,当前队列人数
     * @param m,所报的数
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        //过滤掉非法值
        if(n <= 0|| m<=0) return -1;
        return n == 1 ? 0 : (LastRemaining_Solution(n-1,m) + m)%n;
    }
    //经典方法
    public int LastRemaining_Solution_Class(int n, int m) {
        //过滤掉非法值
        if(n<=0 && m<=0) return -1;
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i=0;i<n;i++) numbers.add(i);
        int index = 0;
        while(numbers.size()>1){
            index = (index + m - 1)%numbers.size();
            numbers.remove(index);
        }
        return numbers.get(0);
    }
}
