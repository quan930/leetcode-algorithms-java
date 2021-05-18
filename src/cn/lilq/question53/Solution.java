package cn.lilq.question53;

import java.util.Arrays;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/18 17:54
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1]>0){
                nums[i] += nums[i-1];
            }
        }
        System.out.println(Arrays.toString(nums));
        return Arrays.stream(nums).max().getAsInt();
    }
}
