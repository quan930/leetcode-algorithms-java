package cn.lilq.question70;

import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/6/2 10:20
 */
public class Solution {
    public int climbStairs(int n) {
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i < n; i++) {
            res[i] = res[i-1]+res[i-2];
        }
        return res[n-1];
    }
}
