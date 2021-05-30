package SortLearn;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    @Test
    public void test(){
//        int[] arr=new int[8000000];
//        for (int i = 0; i < 8000000; i++) {
//            arr[i]=(int)(Math.random()*800000000);
//        }
        int[] arr={4,3,2,1};
       /* Date date_start = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String format_start = simpleDateFormat.format(date_start);
        System.out.println(format_start);*/
        QS(arr,0,arr.length-1);
        /*Date date_end = new Date();
        String format_end = simpleDateFormat.format(date_end);
        System.out.println(format_end);*/

        System.out.println(Arrays.toString(arr));
    }

    public static void QS(int[] target,int L,int R){
        if (L>=R){
            return;
        }
        int left=L;
        int right=R;
        //选取当前序列中最左边的数字作为基准
        int pivot = target[left];
        while(left<right){
            //从右边开始寻找，找到一个小于基数的值
            while(left<right && target[right]>=pivot){
                right--;
            }
            //如果找到就将这个值赋给此时left指向的索引位置
            if(left<right){
                target[left]=target[right];
            }
            //从左边开始寻找，找到一个大于基数的值
            while(left<right && target[left]<=pivot){
                left++;
            }
            //如果找到就将这个值赋给此时right指向的索引位置
            if(left<right){
                target[right]=target[left];
            }
            //当左右指针相遇的时候，将记录的基数赋给此时两个指针所指向的位置
            if (left>=right){
                target[left]=pivot;
            }
        }
        QS(target,L,right-1);
        QS(target,right+1,R);
    }

}
