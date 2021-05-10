package cn.lilq.question6;

/**
 * @author Li Liangquan
 * @date 2019/7/12 2:13 PM
 * 6. Z 字形变换
 * ZigZag Conversion
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (s.length()==0)
            return "";
        StringBuilder stringBuilder = new StringBuilder();
        int group = numRows==1?1:(numRows*2-2);//组数量
        //第一行
        for (int i = 0; i < s.length()/group+(s.length()%group>=1?1:0); i++) {
            stringBuilder.append(s.charAt(i*group));
        }
        if (group==1)
            return stringBuilder.toString();
        System.out.println(stringBuilder.toString());
        //中间行
        for (int i = 2; i <= numRows-1; i++) {
            for (int j = 0; j < s.length() / group + (s.length() % group > 0 ? 1 : 0); j++) {
                if ((j*group+i-1)>=s.length()){
                    break;
                }
                stringBuilder.append(s.charAt(j*group+i-1));
                if ((j*group+numRows*2-i-1)>=s.length())
                    break;
                stringBuilder.append(s.charAt(j*group+numRows*2-i-1));
            }
            System.out.println(stringBuilder.toString());
        }
        //最后一行
        for (int i = 0; i < s.length() / group + (s.length() % group >= 1 ? 1 : 0); i++) {
            if ((i*group+numRows-1)>=s.length())
                break;
            stringBuilder.append(s.charAt(i*group+numRows-1));
        }
        return stringBuilder.toString();
    }
}
