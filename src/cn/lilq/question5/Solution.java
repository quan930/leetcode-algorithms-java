package cn.lilq.question5;

/**
 * @author Li Liangquan
 * @date 2019/7/12 1:51 PM
 * 5. 最长回文子串
 * Longest Palindromic Substring
 */
public class Solution {
    public static String longestPalindrome(String s) {
        int max = 0;
        int start = 0;
        int end = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (isPalindrome(array,i,j)){
                    if ((max)<(j-i+1)){
                        max = j-i+1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.toCharArray().length==0?"":s.substring(start,end+1);
    }
    private static boolean isPalindrome(char[] array,int start,int end){
        for (int i = 0; i <= (end-start)/2; i++) {
            if (array[start+i]!=array[end-i])
                return false;
        }
        return true;
    }
}