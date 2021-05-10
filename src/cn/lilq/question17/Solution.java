package cn.lilq.question17;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/10 20:26
 */
public class Solution {
    static List<String> list = new ArrayList<>();
    static char arr[][] = new char[][]{
            {},
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}};

    public void util(char array[],int index,String s){
        if (index==array.length){
            list.add(s);
            return;
        }
        for (int i = 0; i < 3; i++) {
            String s1 = s.concat(String.valueOf(arr[array[index]-48][i]));
            util(array,index+1,s1);
        }
        if (array[index]=='7'||array[index]=='9'){
            String s1 = s.concat(String.valueOf(arr[array[index]-48][3]));
            util(array,index+1,s1);
        }
    }

    public List<String> letterCombinations(String digits) {
        list.clear();
        char array[] = digits.toCharArray();
        util(array,0,"");
        if ("".equals(digits))
            list.clear();
        return list;
    }
}
