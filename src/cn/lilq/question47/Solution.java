package cn.lilq.question47;

import java.util.*;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/18 09:30
 */
public class Solution {
    private Map<Integer,Integer> numMap;
    private List<List<Integer>> res;
    private int length;

    /**
     * 回溯
     * @param len
     * @param path
     */
    private void backTrack(int len, List<Integer> path){
        if (length==len){
            System.out.println(path);
            res.add(new ArrayList<>(path));
            return;
        }
        numMap.keySet().forEach(integer -> {
            int value =  numMap.get(integer);
            if (value>0){
                path.add(integer);
                numMap.put(integer,value-1);
                backTrack(len+1,path);
                path.remove(path.size()-1);
                numMap.put(integer,value);
            }
        });
    }

    /**
     * 压缩
     * @param nums
     * @return
     */
    private Map<Integer,Integer> compress(int[] nums){
        Map<Integer,Integer> res = new HashMap<>();
        for (int num : nums) {
            res.merge(num, 1, Integer::sum);
        }
        return res;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.numMap = compress(nums);
        this.res = new ArrayList<>();
        this.length = nums.length;
        backTrack(0,new ArrayList<>());
        return new ArrayList<>(res);
    }
}
