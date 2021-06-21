package cn.lilq.question81;

/**
 * @auther: Li Liangquan
 * @date: 2021/6/21 16:31
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        if (target < nums[nums.length-1]){
            for (int i = nums.length-1; i >= 0; i--) {
                if (nums[i]==target)
                    return true;
            }
        }else{
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]==target)
                    return true;
            }
        }
        return false;
    }
}
