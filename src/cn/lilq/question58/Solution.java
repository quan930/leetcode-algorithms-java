package cn.lilq.question58;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/25 09:10
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        String[] temp = s.split(" ");
        if (temp.length==0)
            return 0;
        return temp[temp.length-1].length();
    }
}
