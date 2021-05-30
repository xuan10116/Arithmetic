package SortLearn;

import org.junit.Test;

import java.util.Arrays;

public class MergeSort {

    @Test
    public void test_merge(){
        int arr[] = {8,4,5,7,1,3,6,2};
        int temp[] = new int[arr.length];//归并需要一个临时空间
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    //分+合方法
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left<right){
            int mid = (left+right)/2;//中间索引
            //向左递归分解
            mergeSort(arr, left, mid, temp);
            //向右递归分解
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }

    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;//初始化i，左边有序序列的初始索引
        int j=mid+1;//初始化j，右边有序序列的初始索引
        int t=0;//指向temp数组的当前索引

        //(1)首先将左右两边（有序）的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while(i<=mid && j<=right){
            if (arr[i]>arr[j]){
                temp[t]=arr[j];
                t += 1;
                j += 1;
            }else if(arr[i]<arr[j]){
                temp[t]=arr[i];
                t += 1;
                i += 1;
            }
        }
        //(2),没有处理完毕的一边将其所有剩余数据都补充到temp数组末尾
        if (i<=mid){
            while(i<=mid){
                temp[t]=arr[i];
                t += 1;
                i += 1;
            }
        }else if(j<=right){
            while(j<=right){
                temp[t]=arr[j];
                t += 1;
                j +=1;
            }
        }

        //(3)将temp数组中的数据都复制到原数组中
        //注意，不是每次都拷贝所有
        t = 0;
        int tempLeft = left;
        System.out.println("tempLeft="+tempLeft+",right="+right);
        while(tempLeft <= right){
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
