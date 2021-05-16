package cn.lilq.question41;

import java.util.Arrays;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/16 20:16
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<=0){
                nums[i] = nums.length+1;
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) <= nums.length){
                nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0)
                return i+1;
        }
        return nums.length+1;
    }
}
