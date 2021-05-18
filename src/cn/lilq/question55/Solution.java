package cn.lilq.question55;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/18 20:18
 */
public class Solution {
    private List<Integer> nums;
    private boolean res = false;

    private void backTrack(int index, List<Integer> path){
        if (index >= nums.size())
            return;
        if (index== nums.size()-1){
            System.out.println("yes:"+path);
            res = true;
            return;
        }
        for (int i = nums.get(index); i > 0; i--) {
            if (res)
                return;
            path.add(index+i);
            backTrack(index+i,path);
            path.remove(path.size()-1);
        }
    }

    public boolean canJump(int[] nums) {
        //todo 压缩nums
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]==1 || nums[i]-1 != nums[i+1]){
                list.add(nums[i]);
            }
        }
        list.add(nums[nums.length-1]);
        System.out.println(list);
        this.nums = list;
        this.res = false;
        backTrack(0,new ArrayList<>());
        return res;
    }
}
