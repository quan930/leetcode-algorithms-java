package cn.lilq.question22;

import java.util.*;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/11 10:16
 */
public class Solution {
    private static Set<String> set = new LinkedHashSet<>();

    private void util(int left,int right, String m){
        if (left==0){
            if (right!=0){
                for (int i = 0; i < right; i++) {
                    m = m.concat(")");
                }
            }
//            System.out.println(m);
            set.add(m);
            return;
        }
        for (int i = 0; i < left; i++) {
            int leftNew = left;
            int rightNew = right;
            String sTemp = m;
            for (int j = i; j < left; j++) {
                sTemp = sTemp.concat("(");
                rightNew++;
                leftNew--;
            }
//            System.out.println("--------left:"+leftNew+"\tright:"+rightNew+"\tsTemp:"+sTemp);
            String sTempNew = sTemp;
            for (int j = 0; j < rightNew; j++) {
                sTempNew = sTempNew.concat(")");
//                System.out.println("left:"+leftNew+"\tright:"+(rightNew-j)+"\tsTemp:"+sTempNew);
                util(leftNew,(rightNew-j-1),sTempNew);
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        set.clear();
        util(n,0,"");
        System.out.println(set);
        return new ArrayList<>(set);
    }
}
