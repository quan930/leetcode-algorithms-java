package app.mrquan;

import app.mrquan.question16.Solution;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/10 19:38
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = solution.threeSumClosest(new int[]{1,1,1,0},-100);
        System.out.println(m);
    }
}
