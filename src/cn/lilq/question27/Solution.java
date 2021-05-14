package cn.lilq.question27;

import java.util.Arrays;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/14 10:30
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int startIndex=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[startIndex] = nums[i];
                startIndex++;
            }
        }
        return startIndex;
    }
}
