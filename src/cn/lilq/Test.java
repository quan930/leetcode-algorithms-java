package cn.lilq;



import cn.lilq.question10.Solution;

import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/10 19:38
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println("hello world");
        String s =  "hello world";
        Solution solution = new Solution();
//        System.out.println(s.substring(0,0));
//        System.out.println(s.charAt(s.length()-2));
        //"mississippi"
        //"mis*is*p*."
        System.out.println(solution.isMatch("","c*c*"));
    }
}
