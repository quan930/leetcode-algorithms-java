package cn.lilq.question76;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: Li Liangquan
 * @date: 2021/6/16 10:50
 */
public class Solution {
    /**
     *
     * @param counterS 检验字符串的计数器
     * @param counterT 字符串规则的计数器
     * @return 符合返回true 否则返回false
     */
    private boolean checkMap(Map<Character,Integer> counterS,Map<Character,Integer> counterT){
        for (Character character : counterT.keySet()) {
            if (counterS.get(character)==null){
                return false;
            }else if (counterS.get(character) < counterT.get(character)){
                return false;
            }
        }
        return true;
    }


    public String minWindow(String s, String t) {
        if (s.length()<t.length() || t.length()==0){
            return "";
        }
        String res = null;
        //计数器
        Map<Character,Integer> counterT = new HashMap<>();
        char c;
        for (int i = 0; i < t.length(); i++) {
            c = t.charAt(i);
            if (counterT.get(c)==null){
                counterT.put(c,1);
            }else {
                counterT.put(c,counterT.get(c)+1);
            }
        }
        //init s字符串counter
        Map<Character,Integer> counterS = new HashMap<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < t.length(); i++) {
            right++;
            c = s.charAt(i);
            if (counterS.get(c)==null){
                counterS.put(c,1);
            }else {
                counterS.put(c, counterS.get(c) +1);
            }
        }
        while (left < s.length() && right <= s.length()){
            if (checkMap(counterS,counterT)){
                if (res==null){
                    res=s.substring(left,right);
                }else if (res.length()>(right-left)){
                    res = s.substring(left,right);
                }
                //map --
                c = s.charAt(left);
                counterS.put(c,counterS.get(c)-1);
                left++;
            }else {
                if (right==s.length())
                    break;
                c = s.charAt(right);
                if (counterS.get(c)==null){
                    counterS.put(c,1);
                }else {
                    counterS.put(c, counterS.get(c) +1);
                }
                right++;
            }
        }
        return res==null?"":res;
    }
}
