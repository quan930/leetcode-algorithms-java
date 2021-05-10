package cn.lilq.question15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @auther: Li Liangquan
 * @date: 2019/11/6 08:22
 * 15.三数之和 3Sum
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int m;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                m = findSumZero(nums[i]+nums[j],j+1,nums.length-1,nums);
                if (m!=-1)
                    lists.add(Arrays.asList(nums[i],nums[j],nums[m]));
                while (j<nums.length-1 && nums[j]==nums[j+1])
                    j++;
            }
            while (nums[i]==nums[i+1] && i<nums.length-2 )
                i++;
        }
        return lists;
    }

    /**
     * 找到合为0的索引
     * @param num
     * @param start
     * @param end
     * @param nums
     * @return
     */
    private int findSumZero(int num,int start,int end,int[] nums){
        if ((end-start)<0)
            return -1;
        int m = 0-num;
        return binarySearch(m,start,end,nums);
    }
    //二分查找
    private int binarySearch(int finder,int le,int hi,int[] arr)
    {
        int mid=-1;
        while (le <= hi){
            mid = le + (hi-le)/2;
            if (arr[mid]>finder) hi=mid-1;
            else if (arr[mid] < finder) le=mid+1;
            else return mid;
        }
        return -1;
    }
}
