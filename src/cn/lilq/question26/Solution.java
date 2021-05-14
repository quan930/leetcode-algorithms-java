package cn.lilq.question26;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/14 10:17
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int startIndex = 0;
        int comIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1]==nums[i]){
                comIndex++;
                continue;
            }
            startIndex++;
            comIndex++;
            nums[startIndex] = nums[comIndex];
        }
        return startIndex+1;
    }
}
