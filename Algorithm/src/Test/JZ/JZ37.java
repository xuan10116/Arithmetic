package Test.JZ;

import org.junit.Test;

import java.util.HashMap;

/*
统计一个数字在"升序数组"中出现的次数。
示例1
输入：
[1,2,3,3,3,3,4,5],3
返回值：
4
* */
public class JZ37 {

    @Test
    public void test01(){
        int[] arr = {1,2,3,3,3,3};
        int i = GetNumberOfK02(arr, 3);
        System.out.println(i);
    }

    //低端操作：
    //直接遍历数组，用Map保存每个元素出现的次数。
    //(没有用到升序数组的优势)
    public int GetNumberOfK(int [] array , int k) {
        HashMap<Integer,Integer> count = new HashMap<>();
        for (int value : array) {
            if (count.containsKey(value)) {
                count.put(value, count.get(value) + 1);
            } else {
                count.put(value, 1);
            }
        }
        return count.getOrDefault(k, 0);
    }

    //高端操作(好像也没快多少)
    //二分法，先找到该元素的位置，再在该位置处向两边探索
    public int GetNumberOfK02(int [] array , int k) {
        if (array.length == 0) return 0;
        if (array.length == 1 && array[0] == k) return 1;
        //确定该元素的位置
        int location = binSearch(array,k,0,array.length-1);
        if(location == -1) return 0;
        //计数器,确定位置就是找到了一个
        int counter = 1;
        //左边界
        int left = location-1;
        //右边界
        int right = location+1;
        //向左扩展
        while(left>=0 && array[left] == k){
            counter += 1;
            left -= 1;
        }
        //向右扩展
        while(right<array.length && array[right] == k){
            counter +=1;
            right +=1;
        }

        return counter;
    }

    public int binSearch(int[] arr,int target,int left,int right) {
        int mid = (left + right) / 2;
        if(left>right) return -1;
        if (arr[mid] > target) {
            return binSearch(arr, target, left, mid - 1);
        } else if (arr[mid] < target) {
            return binSearch(arr, target, mid + 1, right);
        } else {
            return mid;
        }
    }
}
