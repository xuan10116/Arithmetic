package SortLearn;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
//        int arr[]={3,9,-1,10,-2};
//        int arr[]={1,2,3,4,5};
        int[] arr=new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i]=(int)(Math.random()*800);
        }
        Date date_start = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.format(date_start);
        System.out.println(date_start);
        int[] bs = IS(arr);
        Date date_end = new Date();
        System.out.println(date_end);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] IS(int[] target){
        int n=target.length;
        int insertVal;
        int insertIndex;//从索引为一的数据开始向已排序的部分插入
        //一共还需要插入n-1个数据
        for(int i=1;i<n;i++){
            insertVal=target[i];//待插入的数据
            insertIndex=i-1;//此处的insertIndex表示，在这之前已经排好序的数据
            //寻找插入位置
            while(insertIndex>=0&&insertVal<target[insertIndex]){
                //将数组中的元素向后挪动
                target[insertIndex+1]=target[insertIndex];
                insertIndex--;
            }
            /*
            适当优化，效率提升不明显
            //判断当前得出的该插入的位置是否就是本来数据存储的位置
            if(insertIndex++ != i) target[insertIndex]=insertVal;
            */
            insertIndex++;
            target[insertIndex]=insertVal;
        }
        return target;
    }
}
