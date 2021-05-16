package cn.lilq.question39;

import java.util.*;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/16 15:09
 */
public class Solution {
    private int[] candidates;
    private int target;
    private Set<List<Integer>> res = new HashSet<>();
    private void backtrack(int sum,List<Integer> url){
        if (sum>target){
            return;
        }
        if (sum==target){
            List<Integer> list = new ArrayList<>(url);
            list.sort(Comparator.comparingInt(o -> o));
            res.add(list);
        }
        for (int candidate : candidates) {
            if ((sum+candidate) > target)
                return;
            url.add(candidate);
            backtrack(sum+candidate,url);//回溯
            url.remove(url.size()-1);
        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        backtrack(0,new ArrayList<>());
//        System.out.println(res);
        return new ArrayList<>(res);
    }
}
