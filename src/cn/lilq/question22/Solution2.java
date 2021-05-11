package cn.lilq.question22;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/11 11:35
 * 回溯法
 */
public class Solution2 {
    List<String> list = new ArrayList<>();

    public void util(int n,int left,int right,String s){
        if (left>n || right>left)//回溯
            return;

        if ((left+right) == (n*2)){
            list.add(s);
            System.out.println(s);
            return;
        }
        util(n,left+1,right,s.concat("("));
        util(n,left,right+1,s.concat(")"));
    }

    public List<String> generateParenthesis(int n) {
        if (n==0)
            return new ArrayList<>();
        list.clear();
        util(n,0,0,"");
        return list;
    }
}
