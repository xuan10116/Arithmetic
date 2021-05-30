package Test.JZ;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
* 如何得到一个数据流中的中位数？
* 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
* 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
* 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
* */
public class JZ63 {

    //方法三：使用堆（NC上的最优解）
    //我们可以将流数据分为三部分
    //(0..) 中位数 (..n-1),我们，左半部分使用大根堆，右半部分使用最小堆，中位数就是小根堆的堆顶
    private int count = 0;
    //minHeap,使用默认的比较器，数据从小到大，就是作为一个小根堆
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //maxHeap,使用自己写的比较器，数据从大到小排序，就是一个大根堆
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    public void InsertBest(Integer num) {
        if(count%2 == 0){
            /**
             * 当数据总数为偶数时，新加入的元素，应当进入小根堆
             * （注意不是直接进入小根堆，而是经大根堆筛选后，取大根堆中最大元素进入小根堆）
             * 新加入的元素先入到大根堆，有大根堆筛选出队中的最大元素
             */
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            //从“大根堆中筛选的最大元素”进入“小根堆”
            minHeap.offer(filteredMaxNum);
        }else{
            /*
            * 当数据总数为奇数时，新加入的元素，应该进入大根堆
            * （注意不是直接进入大根堆，而是经小根堆筛选后，取小根堆中最大元素进入大根堆）
            * 新加入的元素先到小根堆，由小根堆筛选出堆中最小的元素
            * */
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            //筛选后的“小根堆中的最小元素”进入大根堆
            maxHeap.offer(filteredMinNum);
        }
        count += 1;
    }

    public Double GetMedianBest() {
        if (count % 2 == 0)
            return new Double((minHeap.peek() + maxHeap.peek()))/2;
        else{
            return new Double(minHeap.peek());
        }
    }


    //用来存储当前流中元素
    ArrayList<Double> streamone  = new ArrayList<>();
    //方法一：暴力
    public void Insert(Integer num) {
        streamone.add(Double.parseDouble(num+""));
    }
    public Double GetMedian() {
        streamone.sort((o1, o2) -> {
            if (o1>o2) return 1;
            else if (o1<o2) return -1;
            return 0;
        });
        int size = streamone.size();
        //奇数
        if ((size&1) != 0) return (streamone.get(size/2));
        //偶数
        else return (streamone.get(size/2-1)+streamone.get(size/2)) / 2;
    }

    //方法二：稍有优化，将方法一的sort排序改为插入排序(理论上更快，实际上更慢了)
    public void Insert2(Integer num) {
        if(streamone.size()==0){
            streamone.add(Double.parseDouble(num+""));
        }else{
            int i = 0;
            for (;i<streamone.size();i++){
                if (streamone.get(i)<num){

                }else{
                    streamone.add(i,Double.parseDouble(num+""));
                    break;
                }
            }
            if (i == streamone.size()){
                streamone.add(Double.parseDouble(num+""));
            }
        }
    }
    public Double GetMedian2() {
        int size = streamone.size();
        //奇数
        if ((size&1) != 0) return (streamone.get(size/2));
            //偶数
        else return (streamone.get(size/2-1)+streamone.get(size/2)) / 2;
    }

//统一的模拟流输入的方法
    public void caseout(double[] stream){
        for (double c : stream) {
            Insert2((int) c);
            Double aDouble = GetMedian2();
            System.out.println(aDouble+" ");
        }
    }

    @Test
    public void test(){
        double[] stream = {5,2,3,4,1,6,7,0,8};
        caseout(stream);
    }
}
