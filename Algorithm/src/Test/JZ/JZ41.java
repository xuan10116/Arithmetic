package Test.JZ;

import java.util.ArrayList;

/*
* 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100.
* 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
* 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
* 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
* */
public class JZ41 {
    //滑动窗口（双指针）解法
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //存放结果
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //初始的窗口的左右边界
        int l=1,r=2;

        while(l < r){
            //由于是连续的，差为 1 的等差序列，则该序列的sum = (a1 + an)*n/2
            int cur = (l + r) *(r -l + 1) / 2;
            //相等，那么就将窗口范围内所有数添加进结果集
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i=l;i<=r;i++){
                    list.add(i);
                }
                result.add(list);
                //窗口左边界收缩，促使继续向后探索，即促使窗口继续向右滑动
                l++;
            }else if(cur < sum){
                //当序列的sum小于指定sum，则窗口向右扩展。
                r++;
            }else{
                //当前序列的sum大于指定的sum，窗口左边界收缩
                l++;
            }
        }
        return result;
    }
}
