package SortLearn;

import java.util.ArrayList;
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4,6,8,5,9,0,-9,90,80,-50,-100};
        heapSort(arr);
    }

    public static void heapSort(int arr[]){
        int temp;
        System.out.println("HeapSort...");

        //1,先将数组中的无序列构成一个堆，根据升序/降序要求选择大顶堆或小顶堆
        for (int i = arr.length/2 -1; i >=0; i--) {
            adjustHeap(arr,i,arr.length);
        }
        //2,将堆顶元素与末尾元素交换，即将此时的最大元素放在数组中未排序的末端
        //3,重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
        for (int j=arr.length-1;j>0;j--){//j就是当前数组中未排序元素的个数
            //将堆顶元素与末尾元素交换，将最大元素放在数组中未排序的末端
            temp=arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示对多少个数据进行调整，length是在逐渐减少
     */
    public static void adjustHeap(int arr[],int i,int length){
        int temp = arr[i];//先取出当前值，保存在临时变量里面
        //开始调整
        //说明
        //1，k=i*2+1,即此时k指向的是i（i是当前堆的堆顶）的左子节点
        for (int k = i*2+1;k<length;k = k*2+1){
            //判断此时节点的左右节点哪一个大，将大的与当前堆顶元素交换
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            if (arr[k]>temp){
                //我们将大的元素赋给了当前堆顶元素
                arr[i] = arr[k];
                //重要，将i指向k，继续循环比较，对以k为堆顶的堆进行堆排序
                i = k;
            }else{
                break;
            }
        }
        //将之前保存的堆顶元素赋给“最终”替换了它的那个元素
        //相当于就是将堆顶元素向下沉，所能沉到的最低位置就是 当前的 i
        arr[i] = temp;
    }
}
