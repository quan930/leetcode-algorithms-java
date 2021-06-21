package cn.lilq.question78;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/6/21 14:13
 */
public class Solution {
    private List<List<Integer>> res;
    private int[] nums;
    private void backTrack(int start,List<Integer> path){
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backTrack(i+1,path);
            path.remove(path.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        res = new ArrayList<>();
        backTrack(0,new ArrayList<>());
        return res;
    }
}
