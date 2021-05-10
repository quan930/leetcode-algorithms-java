package cn.lilq.question12;

/**
 * @auther: Li Liangquan
 * @date: 2019/11/5 23:55
 * 12.整数转罗马数字
 * Integer to Roman
 * 方法有待优化
 */
public class Solution {
    public String intToRoman(int num) {
        if (0>=num || num>=4000) return "";
        char[] chars = {'I','V','X','L','C','D','M'};
        int size= (int)Math.log10(num)+1;
        StringBuilder stringBuilder = new StringBuilder();
        int n;
        for (int i = 1; i <= size; i++) {
            n = (num%(int)(Math.pow(10,i)))/(int)(Math.pow(10,i-1));
            if (n<4){
                for (int j = 0; j < n; j++) {
                    stringBuilder.insert(0,chars[i*2-2]);
                }
            }else if(n==4){
                stringBuilder.insert(0,chars[i*2-1]);
                stringBuilder.insert(0,chars[i*2-2]);
            }else if (n==9){
                stringBuilder.insert(0,chars[i*2]);
                stringBuilder.insert(0,chars[i*2-2]);
            }else {
                for (int j = 5; j < n; j++) {
                    stringBuilder.insert(0,chars[i*2-2]);
                }
                stringBuilder.insert(0,chars[i*2-1]);
            }
        }
        return stringBuilder.toString();
    }
}
