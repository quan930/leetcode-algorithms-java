package cn.lilq.question60;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/25 11:16
 */
public class Solution {
    private List<Integer> res;

    private void backTrack(int number, List<Integer> list){
        if (list.size()==0){
            System.out.println(number);
            res.add(number);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            int remove = list.remove(i);
            backTrack(number*10+remove,list);
            list.add(i,remove);
        }
    }

    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        res = new ArrayList<>();
        backTrack(0,list);
        return res.get(k-1).toString();
    }
}
