package app.mrquan.question16;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/10 19:21
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Integer sum = null;
        int temp;
//        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    temp = nums[i] + nums[j] + nums[k];
                    System.out.println(temp);
                    if (sum==null)
                        sum = temp;
                    if (Math.abs(sum-target)>Math.abs(temp-target))
                        sum = temp;
                }
            }
        }
        return sum;
    }
}
