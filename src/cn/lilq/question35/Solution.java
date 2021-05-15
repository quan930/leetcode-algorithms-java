package cn.lilq.question35;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/15 15:32
 */
public class Solution {
    int binarySearch(int left,int right,int[] nums,int target){
        if (left>right){
            System.out.println("left:"+left+"\tright:"+right);
            return left;
        }
        int mid = left+(right-left)/2;
        if (nums[mid]==target)
            return mid;
        if (target > nums[mid])
            return binarySearch(mid+1,right,nums,target);
        return binarySearch(left, mid-1, nums, target);
    }

    public int searchInsert(int[] nums, int target) {
        return binarySearch(0,nums.length-1,nums,target);
    }
}
