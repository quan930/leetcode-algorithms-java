package cn.lilq;



import cn.lilq.question22.Solution;
import cn.lilq.question22.Solution2;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/10 19:38
 */
public class Test {
    private List<List<Integer>> lists;

    void test1(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        lists.add(list);
    }

    void tesr(){
        lists = new ArrayList<>();
        test1();
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.tesr();
        System.out.println(test.lists);
    }
}
