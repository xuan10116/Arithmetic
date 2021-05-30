package Test;

import org.junit.Test;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，
 * 其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
 *
 * 要求：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n^2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次
 */
public class LeeCode287 {
    @Test
    public void test01(){
        int[] nums = {1,2,3,4,5,5,5,8,10,11,12,13};
        int duplicate01 = findDuplicate01(nums);
        System.out.println(duplicate01);
    }

    @Test
    public void test02(){
        int[] nums = {1,2,3,4,5,5,5,8,10,11,12,13};
        int duplicate02 = findDuplicate02(nums);
        System.out.println(duplicate02);
    }

    //使用二分查找：按值二分
    public int findDuplicate01(int[] nums){
        int len = nums.length;
        int start = 1;
        int end = len-1;
        while(start<end){
            int mid = start + (end - start) / 2;
            int counter = 0;
            for(int num:nums){
                if(num <= mid){
                    counter++;
                }
            }
            if(counter > mid){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

    //使用快慢指针
    public int findDuplicate02(int[] nums){
        int fast = nums[nums[0]];
        int slow = nums[0];
        while(fast != slow){
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        slow = 0;
        while(fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
