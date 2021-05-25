package cn.lilq.question65;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/25 19:07
 */
public class Solution {
    public boolean isNumber(String s) {
        if (s.contains("F") || s.contains("f") || s.contains("d") || s.contains("D")) {
            return false;
        }
        try {
            Double.parseDouble(s);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
