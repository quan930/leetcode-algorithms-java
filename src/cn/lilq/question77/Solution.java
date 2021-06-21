package cn.lilq.question77;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/6/21 13:53
 */
public class Solution {
    private int k;
    private int n;
    private List<List<Integer>> res;
    private void backTrack(int min,List<Integer> path){
        if (path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = min; i <= n; i++) {
            path.add(i);
            backTrack(i+1,path);
            path.remove(path.size()-1);
        }
    }

    /**
     *
     * @param n 值范围
     * @param k 数长
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        this.res = new ArrayList<>();
        backTrack(1,new ArrayList<>());
        return res;
    }
}
