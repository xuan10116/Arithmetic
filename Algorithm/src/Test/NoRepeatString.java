package Test;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class NoRepeatString {

    @Test
    public void test01(){
        int[] arr = {2,3,4,3,5};
        int maxLength = maxLength01(arr);
        System.out.println(maxLength);
    }

    @Test
    public void test02(){
        int[] arr = {3,2,4,3,5,6};
        int maxLength = maxLength02(arr);
        System.out.println(maxLength);
    }

    //1,HashMap
    public int maxLength01(int[] arr) {
        if(arr.length == 0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int i=0,j=0;//双指针，j指向当前子串首，i指向当前字串尾
        for(;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                j=Math.max(j,map.get(arr[i])+1);
            }
            map.put(arr[i],i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    //2,Queue
    public int maxLength02(int[] arr){
        Queue<Integer> queue = new LinkedList<>();
        int maxLength = 0;
        for(int c : arr){
            while(queue.contains(c)){
                queue.poll();
            }
            queue.add(c);
            maxLength = Math.max(maxLength,queue.size());
        }
        return maxLength;
    }


}

