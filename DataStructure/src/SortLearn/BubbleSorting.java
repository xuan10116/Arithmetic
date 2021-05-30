package SortLearn;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSorting {
    public static void main(String[] args) {
//        int arr[]={3,9,-1,10,-2};
        int arr[]={1,2,3,4,5};
        int[] bs = BS_esay(arr);

        System.out.println( Arrays.toString(bs));
    }
    public static int[] BS_esay(int[] target){
        int n=target.length;
        int temp;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(target[j]>target[j+1]){
                    temp=target[j];
                    target[j]=target[j+1];
                    target[j+1]=temp;
                }
                System.out.println("i="+i+",j="+j+",排序的结果是："+"\t"+Arrays.toString(target));
            }
        }
        return target;
    }

    public static int[] BS_adc(int[] target){
        int n=target.length;
        int temp;
        boolean flag=false;//交换标志，未交换则为false
        for (int i=0;i<n-1;i++){
            for (int j = 0; j < n-1-i; j++) {
                if (target[j]>target[j+1]){
                    temp=target[j];
                    target[j]=target[j+1];
                    target[j+1]=temp;
                    flag=true;//进入交换，置为true
                }
//                System.out.println("i="+i+",j="+j+",排序的结果是："+"\t"+Arrays.toString(target));
            }
            if(!flag){
                break;
            }
        }
        return target;
    }

    @Test
    public void test_Adc(){
//        int arr[]={3,9,-1,10,-2};
//        int arr[]={1,2,3,4,5};
        int[] arr=new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i]=(int)(Math.random()*8000000);
        }
        Date date_start = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.format(date_start);
        System.out.println(date_start);
        int[] bs = BS_adc(arr);
        Date date_end = new Date();
        System.out.println(date_end);
    }
}

