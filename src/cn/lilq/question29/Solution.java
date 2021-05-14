package cn.lilq.question29;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/14 10:57
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int minusCount = 0;
        if (dividend > 0){
            minusCount++;
            dividend = -dividend;
        }
        if (divisor > 0){
            minusCount++;
            divisor = -divisor;
        }
        int res = 0;
        while (dividend <= divisor){
            dividend -= divisor;
            res ++;
        }
        return minusCount==1 ? -res : res;
    }
}
