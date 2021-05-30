package BinarySearch;

import org.junit.Test;

public class BinarySearchNoRe {
    @Test
    public void test_noRe(){

        int[] a = {1,8,10,89,100,123};
        int resIndex = binarySearchNoRe(a, 123);
        System.out.println(resIndex);
    }

    //二分查找的非递归实现
    public static int binarySearchNoRe(int[] a,int target){
        //初始化左右游标，先指向序列的头和尾
        int left = 0;
        int right = a.length-1;

        //当左游标不大于右游标时保持循环
        while(left<=right){
            //中间游标
            int mid = (left+right)/2;
            //当中间元素等于目标元素时，返回中间游标
            if (a[mid]==target) return mid;
            //否则，如果中间元素的值大于目标元素，则将搜索范围缩至（left，mid-1）
            else if (a[mid] > target) right = mid-1;
            //再否则，如果中间元素的值小于目标元素，则将搜索范围缩至（mid+1，right）
            else if (a[mid] < target) left = mid +1;
        }
        return -1;
    }
}
