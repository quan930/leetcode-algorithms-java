package cn.lilq.question9;

/**
 * @author Li Liangquan
 * @date 2019/7/15 12:21 PM
 * 9.回文数
 * Palindrome Number
 */
public class Solution {
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println( isPalindrome(121));
    }
}
