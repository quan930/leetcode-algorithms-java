package app.mrquan.question7;

/**
 * @author Li Liangquan
 * @date 2019/7/13 2:55 PM
 * 7. 整数反转
 * Reverse Integer
 */
public class Solution {
    public static int reverse(int x) {
        String s = String.valueOf(x);
        char[] array = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = array.length-1; i > 0 ; i--) {
            stringBuilder.append(array[i]);
        }
        if (array[0]=='-')
            stringBuilder.insert(0, '-');
        else {
            stringBuilder.append(array[0]);
        }
//        System.out.println(stringBuilder.toString());
        try {
            return Integer.parseInt(stringBuilder.toString());
        }catch (java.lang.NumberFormatException e){
            return 0;
        }
    }
}
