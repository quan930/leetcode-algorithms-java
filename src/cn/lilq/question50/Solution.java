package cn.lilq.question50;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/18 13:53
 */
public class Solution {
    public double myPow(double x, int n) {
        if (x==1){
            return 1;
        }
        if (x==-1)
            return n%2==1?-1:1;
        if (n==0)
            return 1;
        double res = x;
        if (n>0){
            for (int i = 1; i < n; i++) {
                res *= x;
            }
        }else {
            res = 1;
            long nNew = n;
            nNew = Math.abs(nNew);
            for (int i = 0; i < nNew; i++) {
                res /= x;
                if (res==0)
                    return 0;
            }
        }
        return res;
    }
}
