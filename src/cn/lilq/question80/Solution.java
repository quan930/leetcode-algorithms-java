package cn.lilq.question80;

import java.util.Arrays;

/**
 * @auther: Li Liangquan
 * @date: 2021/6/21 16:00
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0;
        int right=1;
        int indexCounter=1;

        while (right<nums.length){
            if (nums[left]!=nums[right]){
                left++;
                nums[left] = nums[right];
                right++;
                indexCounter=1;
            }else if (indexCounter<2){
                left++;
                nums[left] = nums[right];
                right++;
                indexCounter++;
            }else {
                indexCounter++;
                right++;
            }
        }
        return left+1;
    }
}
