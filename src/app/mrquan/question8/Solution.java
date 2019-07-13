package app.mrquan.question8;

/**
 * @author Li Liangquan
 * @date 2019/7/13 5:03 PM
 * 8.字符串转换整数 (atoi)
 * String to Integer (atoi)
 */
public class Solution {
    public static int myAtoi(String str) {
        StringBuilder builder = new StringBuilder();
        boolean plusMinus = true;
        //清除前后空格
        str = str.trim();
        if (str.length()==0)
            return 0;
        //判断开头
        if (str.charAt(0)=='-'){
            plusMinus=false;
        } else{
            System.out.println(str.charAt(0));
            if ((str.charAt(0)+"").matches("[+0-9]{1,}"))
                builder.append(str.charAt(0));
            else
                return 0;
        }
        for (int i = 1; i < str.length(); i++) {
            if (!(str.charAt(i)+"").matches("[0-9]{1,}"))
                break;
            builder.append(str.charAt(i));
        }
        System.out.println(builder.toString());
        if (builder.toString().startsWith("+"))
            builder.deleteCharAt(0);
        try {
            return builder.toString().length()==0?0:Integer.parseInt(plusMinus?builder.toString():"-"+builder.toString());
        }catch (java.lang.NumberFormatException e){
            if (plusMinus)
                return Integer.MAX_VALUE;
            return Integer.MIN_VALUE;
        }
    }
}
