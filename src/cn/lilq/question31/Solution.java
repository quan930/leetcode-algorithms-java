package cn.lilq.question31;

import java.util.Arrays;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/14 18:27
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int k = -1;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]){
                k = i;
                break;
            }
        }
        if (k==-1){
            Arrays.sort(nums);
            return;
        }
        int l = -1;
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] > nums[k]){
                l = i;
                int temp = nums[l];
                nums[l] = nums[k];
                nums[k] = temp;
                Arrays.sort(nums,k+1,nums.length);
                break;
            }
        }
    }
}