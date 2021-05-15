package cn.lilq.question34;

import java.util.*;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/15 14:16
 */
public class Solution {
    private int binarySearch(int left,int right,int[] nums,int target){
        if (left > right){
            return -1;
        }
        int mid = left+(right-left)/2;
        if (nums[mid]==target)
            return mid;
        if (target > nums[mid]){
            return binarySearch(mid+1,right,nums,target);
        }else {
            return binarySearch(left,mid-1,nums,target);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int m = binarySearch(0, nums.length-1,nums,target);
//        System.out.println("m:"+m);
        if (m==-1){
            res[0]=-1;
            res[1]=-1;
            return res;
        }
        int temp = m;
        while (temp>0 && nums[temp-1]==nums[m]){
            temp--;
        }
        res[0] = temp;
        temp = m;
        while (temp< nums.length-1 && nums[temp+1]==nums[m]){
            temp++;
        }
        res[1] = temp;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.searchRange(new int[]{},1);
        System.out.println(Arrays.toString(res));
    }
}
