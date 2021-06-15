package cn.lilq.question75;

/**
 * @auther: Li Liangquan
 * @date: 2021/6/15 21:14
 */
public class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int second = nums.length-1;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (i>second)
                break;
            if (nums[i]==0){
                temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
                zero++;
            }else if (nums[i]==2){
                temp = nums[second];
                nums[second] = nums[i];
                nums[i] = temp;
                second--;
                i--;
            }
        }
    }
}
