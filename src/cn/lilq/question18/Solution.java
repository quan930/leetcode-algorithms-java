package cn.lilq.question18;

import java.util.*;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/10 21:14
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length==0)
            return new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> lists = new LinkedHashSet<>();
        int temp;
        int m;
        for (int i = 0; i < nums.length-3; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                for (int k = j+1; k < nums.length-1; k++) {
                    temp = nums[i] + nums[j] + nums[k];
                    m = binarySearch(target-temp,k+1,nums.length-1,nums);
                    if (m!=-1){
                        lists.add(Arrays.asList(nums[i],nums[j],nums[k],nums[m]));
                    }
                }
            }
        }
        return new ArrayList<>(lists);
    }


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
