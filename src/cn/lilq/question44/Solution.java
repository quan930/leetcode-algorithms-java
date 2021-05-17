package cn.lilq.question44;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/17 13:56
 */
public class Solution {
    private String s, p;
    private boolean res;

    private void backTrack(int sIndex,int pIndex){
//        System.out.println("sIndex:"+sIndex+"\tpIndex:"+pIndex);
        if (sIndex==s.length() && pIndex==p.length()){
            System.out.println("正确结果");
            res = true;
            return;
        }
        if(sIndex==s.length() && p.charAt(pIndex)=='*' && pIndex==p.length()-1){
            System.out.println("正确结果");
            res = true;
            return;
        }
        if (pIndex<p.length() && p.charAt(pIndex)=='?')
            backTrack(sIndex+1,pIndex+1);
        if (pIndex<p.length() && p.charAt(pIndex)=='*'){
            for (int i = sIndex; i < s.length(); i++) {
                if (res)
                    return;
                if (pIndex == p.length()-1){
                    res = true;
                    return;
                }
                if (s.charAt(i) == p.charAt(pIndex+1) || p.charAt(pIndex+1)=='?')
                    backTrack(i,pIndex+1);
            }
        }
        if (sIndex<s.length() && pIndex<p.length() && s.charAt(sIndex)==p.charAt(pIndex)){
            backTrack(sIndex+1, pIndex+1);
        }
    }

    //压缩
    private String compression(String p){
        StringBuilder stringBuilder = new StringBuilder();
        Character character = null;
        for (int i = 0; i < p.length(); i++) {
            if (character==null){
                character = p.charAt(i);
                stringBuilder.append(p.charAt(i));
                continue;
            }
            if (character=='*' && p.charAt(i)=='*'){
                continue;
            }
            character = p.charAt(i);
            stringBuilder.append(p.charAt(i));
        }
        return stringBuilder.toString();
    }

    public boolean isMatch(String s, String p) {
        if (s.equals(p))
            return true;
        this.s = s;
        //todo p 压缩
        this.p = compression(p);
        if (this.p.equals("*"))
            return true;
        res = false;
        backTrack(0,0);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Boolean b = solution.isMatch("mississippi","m??*ss*?i*pi");
        System.out.println(b);
    }
}
//"abcabczzzde"
//"*abc???de*"

//"adceb"
//"*a*b"

//"acdcb"
//"a*c?b"

//"abcabczzzde"
//"*abc???de*"

//"mississippi"
//"m??*ss*?i*pi"