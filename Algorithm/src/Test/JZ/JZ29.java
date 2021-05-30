package Test.JZ;

import org.junit.Test;

import java.util.ArrayList;

public class JZ29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input == null || input.length==0 || k>input.length) return new ArrayList();
        ArrayList<Integer> result = new ArrayList<>();
        heapSort(input);
        for(int i=0;i<k;i++){
            result.add(input[i]);
        }
        return result;
    }

    //使用堆排序
    public void heapSort(int arr[]){
        int temp;
        //首先将元素中的无序列构成一个堆
        //从“最 底 部（最右下角）”的堆开始规整，逐渐向上。
        //i = arr.length/2 -1,得到的就是最右下角的堆的堆顶元素的索引
        for (int i = arr.length/2 -1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }

        //将堆顶元素与末尾元素交换，即将此时的最大元素放在数组中未排序的末端
        for (int j=arr.length-1;j>0;j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            //调整堆结构，将换到堆顶的元素再次沉淀下去
            adjustHeap(arr,0,j);
        }
    }


    //调整数组使其满足堆的结构（构成的是大根堆）
    /*
    * arr，待调整的数组
    * i，当前堆的堆顶元素的索引
    * length，表示对多少个数据进行调整，length在逐渐减少
    * */
    public void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];
        //i指向的是当前堆的堆顶
        for (int k = i*2+1;k<length;k = k*2 +1){
            //在当前数组范围内，看该堆顶元素的左右子节点哪个大，将大的与堆顶元素比较
            if (k+1 < length && arr[k]<arr[k+1]) k++;
            //当前堆下的元素有比堆顶元素大的
            if (arr[k]>temp){
                //我们就将该元素的值赋给堆顶元素
                arr[i] = arr[k];
                //将i指向k，再对以k为堆顶的元素进行堆排序
                i = k;
            }else{
                //如果当前堆顶元素大于其左右子堆顶元素，那么说明当前堆调整完毕，退出向下沉淀最初堆顶的循环
                break;
            }
        }
        //将最初保存的堆顶元素赋值给“最终替换了”它的那个元素的索引上,
        //相当于就是将堆顶元素向下沉，所能沉到的最低位置就是 当前的 i
        arr[i] = temp;
    }

    @Test
    public void test(){
        int[] arr = {4,5,1,6,2,7,3,8};
        int k = 4;
        ArrayList<Integer> integers = GetLeastNumbers_Solution(arr, k);
        System.out.println(integers.toString());
    }

}
