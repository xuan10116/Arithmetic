package BinarySearch;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 注意：使用二分查找的前提是  序列是有序的
 */
public class BinarySearch {
    @Test
    public  void test_Single() {
        int[] a = {1,8,10,89,100,123};
        int resIndex = binarySearch_Single(a, 0, a.length - 1, 9);
        System.out.println(resIndex);
    }

    //待查找的值只有一个
    public static int binarySearch_Single(int a[],int left,int right,int findVal){
        int mid = (right+left) / 2;
        int midVal = a[mid];

        //如果在递归过程中，发现左游标大于右游标，则要查找的数，不在当前序列中
        if(left>right) return -1;

        //当将要寻找的值小于中间值，那么向左递归
        if (findVal<midVal){
            return binarySearch_Single(a,left,mid-1,findVal);
        }else if (findVal>midVal){
            //如果将要寻找的值大于中间值，那么向右递归
            return binarySearch_Single(a,mid+1, right,findVal);
        }else
            //如果要寻找的值等于中间值，那么直接返回中间值的索引
            return mid;
    }

    @Test
    public void test_Set(){
        int[] a = {1,8,10,89,100,100,100,100,100,123};
        ArrayList<Integer> resultSet = binarySearch_Set(a, 0, a.length - 1, 100);
        System.out.println(resultSet);
    }

    //待查找的值有多个
    public static ArrayList<Integer> binarySearch_Set(int a[], int left, int right, int findVal){
        int mid = (right+left) / 2;
        int midVal = a[mid];

        //如果在递归过程中，发现左游标大于右游标，则要查找的数，不在当前序列中
        if(left>right) return new ArrayList<>();

        //当将要寻找的值小于中间值，那么向左递归
        if (findVal<midVal){
            return binarySearch_Set(a,left,mid-1,findVal);
        }else if (findVal>midVal){
            //如果将要寻找的值大于中间值，那么向右递归
            return binarySearch_Set(a,mid+1, right,findVal);
        }else{
            //创建用于存储索引的列表
            ArrayList<Integer> resultSet = new ArrayList<Integer>();

            //因为我们是在一个有序的序列中查找，当我们找到一个指定值时，其紧邻的也就是相同的值

            //1,向mid索引值的左侧开始扫描
            int temp = mid - 1;
            while(true){
                //当当前游标小于0（代表已经从该处向左遍历完了序列）或者左侧值不等于指定值时，就退出循环
                if (temp < 0 || a[temp] != findVal) break;
                //将左侧相同值的索引加入resultSet
                resultSet.add(temp);
                temp -= 1;//游标向左移动
            }

            resultSet.add(mid); //将我们初次查找到的索引值加入resultSet

            //2,向mid索引值的右侧开始扫描
            temp=mid+1;
            while(true){
                //当当前游标走到了序列的最右侧或者游标所指的值不是需要查找的值的时候，就退出循环
                if (temp >a.length-1 || a[temp] != findVal) break;
                resultSet.add(temp);
                temp += 1; //游标右移
            }
            return resultSet;
        }
    }
}