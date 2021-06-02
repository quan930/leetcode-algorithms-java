package cn.lilq.question1141;

import java.math.BigInteger;

/**
 * @auther: Li Liangquan
 * @date: 2021/6/2 11:05
 */
public class Solution {
    static final int MOD = 1000000007;
    public int numOfWays(int n) {
        //3
        long res[][] = new long[n][2];//前为abc 后为aba
        res[0][0] = 6;
        res[0][1] = 6;
        long abc;
        long aba;
        for (int i = 1; i < res.length; i++) {
            abc = (res[i-1][0]*2+res[i-1][1]*2)%MOD;
            aba = (res[i-1][0]*2+res[i-1][1]*3)%MOD;
            res[i][0] = abc;
            res[i][1] = aba;
        }
//        for (int i = 0; i < res.length; i++) {
//            System.out.println(res[i][0]+"\t"+res[i][1]);
//        }
        return (int)(res[n-1][0]+res[n-1][1]) % MOD;
    }
}
