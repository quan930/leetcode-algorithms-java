package cn.lilq.question14;

/**
 * @auther: Li Liangquan
 * @date: 2019/11/6 01:43
 * 14.最长公共前缀
 * Longest Common Prefix
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0)
            return "";
        if (strs.length==1)
            return strs[0];
        String m = findCommonPrefix(strs[0],strs[1]);
        for (int i = 2; i < strs.length; i++) {
            m = findCommonPrefix(m,strs[i]);
        }
        return m;
    }

    private String findCommonPrefix(String a,String b){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Math.min(a.length(),b.length()); i++) {
            if (a.charAt(i)==b.charAt(i))
                stringBuilder.append(a.charAt(i));
            else
                break;
        }
        return stringBuilder.toString();
    }
}
