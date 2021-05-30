package SortLearn;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {

    //交换式希尔排序测试
    @Test
    public void test_swap() {
        int[] arr={8,9,1,7,2,3,5,4,6,0};
        ShellS_Swap(arr);
        System.out.println(Arrays.toString(arr));
    }


    //移位式希尔排序测试
    @Test
    public void test_insert() {
        int[] arr=new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i]=(int)(Math.random()*8000000);
        }
        Date date_start = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.format(date_start);
        System.out.println(date_start);
        ShellS_Insert(arr);
        Date date_end = new Date();
        System.out.println(date_end);
//        System.out.println(Arrays.toString(arr));
    }

    //交换式希尔排序
    public static void ShellS_Swap(int[] target){

        int n=target.length;
        int temp;
        for (int gap=n/2;gap>0;gap/=2){
            for (int i = gap; i < n; i++) {
                for (int j = i-gap; j >= 0; j-=gap) {
                    if (target[j+gap]<target[j]){
                        temp=target[j+gap];
                        target[j+gap]=target[j];
                        target[j]=temp;
                    }
                }
            }
        }
    }



    //移位式希尔排序(希尔的思想+直接插入排序思想)
    public static void ShellS_Insert(int[] target){
        int n = target.length;
        int insertIndex;
        int insertVal;
        //外层循环，确定gap
        for (int gap=n/2;gap>0;gap/=2){
            //内层循环通过 插入排序 来进行排序
            for (int i = gap; i < n; i++) {
                insertIndex=i-gap;//此处表示已排好序的边界索引值为insertIndex
                insertVal=target[i];
                //寻找插入位置
                while(insertIndex>=0 && insertVal<target[insertIndex]){
                    target[insertIndex+gap]=target[insertIndex];
                    insertIndex-=gap;
                }
                //给寻找到的位置上赋值
                insertIndex+=gap;
                target[insertIndex]=insertVal;
            }
        }
    }
}
