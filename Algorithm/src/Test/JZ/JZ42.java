package Test.JZ;

import org.junit.Test;

import java.util.ArrayList;

/*
描述
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。

返回值描述：
对应每个测试案例，输出两个数，小的先输出。

示例1
输入：
    [1,2,4,7,11,15],15
返回值：
    [4,11]
* */
public class JZ42 {

    @Test
    public void test(){
        int[] arr  = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        System.out.println(FindNumbersWithSum(arr,21));
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int minresult = 0;
        boolean modify = true;
        if (array.length == 0 || array==null) return result;
        for (int i=0;i<array.length;i++){
            int target = sum - array[i];
            int friendIndex = binSearch(array,0,array.length-1,target);
            if (friendIndex != -1){
                if (modify){
                    result.add(array[i]);
                    result.add(target);
                    minresult = array[i] * target;
                    modify = false;
                }else if (array[i]*target<minresult){
                    result.add(array[i]);
                    result.add(target);
                    minresult = array[i] * target;
                }
            }
        }


        if (result.size()>0 && result.get(0)>result.get(1)){
            int temp = result.get(0);
            result.set(0,result.get(1));
            result.set(1,temp);
        }
        return result;
    }

    public int binSearch(int[] arr,int left,int right,int value){
        int mid = (left+right)/2;
        if (left > right) return -1;
        if (value > arr[mid]){
            return binSearch(arr,mid + 1,right,value);
        }else if(value < arr[mid]){
            return binSearch(arr,left,mid-1,value);
        }else{
            return mid;
        }
    }
}
