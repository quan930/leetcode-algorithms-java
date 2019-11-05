package app.mrquan.question13;

/**
 * @auther: Li Liangquan
 * @date: 2019/11/6 00:52
 * 13.罗马数字转整数
 * Roman to Integer
 */
public class Solution {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        System.out.println(chars);
        int beforeSize = 1;
        int num=0;
        int currentSize;
        for (int i = chars.length-1; i >= 0 ; i--) {
            currentSize =  charToInt(chars[i]);
            if (currentSize>=beforeSize){
                num+=currentSize;
            }else {
                num-=currentSize;
            }
            beforeSize = currentSize;
        }
        return num;
    }
    private static int charToInt(char c) {
        int t = 0;
        if(c == 'I') {
            t = 1;
        } else if(c == 'V') {
            t = 5;
        } else if(c == 'X') {
            t = 10;
        } else if(c == 'L') {
            t = 50;
        } else if(c == 'C') {
            t = 100;
        } else if(c == 'D') {
            t = 500;
        } else if(c == 'M') {
            t = 1000;
        }
        return t;
    }
}
