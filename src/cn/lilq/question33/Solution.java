package cn.lilq.question33;

import java.util.Arrays;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/15 13:06
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (target < nums[nums.length-1]){
            for (int i = nums.length-1; i >= 0; i--) {
                if (nums[i]==target)
                    return i;
            }
        }else{
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]==target)
                    return i;
            }
        }
        return -1;
    }
}
