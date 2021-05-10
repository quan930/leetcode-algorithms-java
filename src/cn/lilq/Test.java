package cn.lilq;

import cn.lilq.question18.Solution;

import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/10 19:38
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.fourSum(new int[]{},0);
        lists.forEach(System.out::println);
    }
}
