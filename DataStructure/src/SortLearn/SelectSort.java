package SortLearn;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectSort {

    @Test
    public void SS(){
        int[] arr=new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i]=(int)(Math.random()*8000000);
        }
        Date date_start = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.format(date_start);
        System.out.println(date_start);
        SS(arr);
        Date date_end = new Date();
        System.out.println(date_end);
    }

    public static int[] SS(int[] target){
        int n=target.length;
        int minIndex=0;
        int min=target[0];

        boolean flag=false;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(min>target[j]){
                    min=target[j];
                    minIndex=j;
                    flag=true;
                }
            }
            //将选择出来的minIndex位置处的值（min）与i位置处的值交换
            target[minIndex]=target[i];
            target[i]=min;
            //在接下来的过程中，默认指定i的下一位上的数值为最小值，并将minIndex进行修改（因为前面的已经排好序了）
            min=target[i+1];
            minIndex=i+1;

            if (!flag){
                break;
            }else{
                flag=false;
            }
        }
        return target;
    }
}
