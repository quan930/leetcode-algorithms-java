package cn.lilq.question46;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/18 09:15
 */
public class Solution {
    private int[] nums;
    private List<List<Integer>> res;

    private void backTrack(int len, List<Integer> path){
        if (len==nums.length){
            System.out.println(path);
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])){
                path.add(nums[i]);
                backTrack(len+1,path);
                path.remove(path.size()-1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.res = new ArrayList<>();
        backTrack(0,new ArrayList<>());
        return res;
    }
}
