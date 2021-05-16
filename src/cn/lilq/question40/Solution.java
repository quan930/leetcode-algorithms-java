package cn.lilq.question40;

import java.util.*;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/16 16:04
 */
public class Solution {
    private Map<Integer,Integer> candidates;//记数
    private int target;
    private Set<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = new HashMap<>();
        this.res = new HashSet<>();
        for (int candidate : candidates) {
            this.candidates.merge(candidate, 1, Integer::sum);
        }
//        System.out.println(this.candidates);
        this.target = target;
        backTrack(0,new ArrayList<>());
//        System.out.println(res);
        return new ArrayList<>(res);
    }

    private void backTrack(int sum,List<Integer> path) {
        if (sum==target){
//            System.out.println(path);
            List<Integer> list = new ArrayList<>(path);
            list.sort(Comparator.comparingInt(o -> o));
//            System.out.println(list);
            res.add(list);
        }

        candidates.keySet().forEach(integer -> {
            if (candidates.get(integer)==0){
                return;
            }
            if ((sum+integer) > target)
                return;
            path.add(integer);
            candidates.put(integer,candidates.get(integer)-1);
            backTrack(sum+integer,path);
            path.remove(path.size()-1);
            candidates.put(integer,candidates.get(integer)+1);
        });
    }
}
