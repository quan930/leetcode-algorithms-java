package cn.lilq.question67;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/25 19:33
 */
public class Solution {
    public String addBinary(String a, String b) {
        int aIndex = a.length()-1;
        int bIndex = b.length()-1;
        StringBuilder stringBuilder = new StringBuilder();
        int temp=0;
        while (aIndex>=0 && bIndex>=0){
            int numA = (int)a.charAt(aIndex)-(int)('0');
            int numB = (int)b.charAt(bIndex)-(int)('0');
            if ((numA+numB+temp)==3){
                temp = 1;
                stringBuilder.append("1");
            }else if ((numA+numB+temp)==2){
                temp = 1;
                stringBuilder.append("0");
            }else {
                stringBuilder.append((numA + numB + temp)+"");
                temp = 0;
            }
            aIndex--;
            bIndex--;
        }
        while (aIndex>=0){
            int numA = (int)a.charAt(aIndex)-(int)('0');
            if ((numA+temp)==2){
                temp = 1;
                stringBuilder.append("0");
            }else {
                stringBuilder.append((numA + temp)+"");
                temp = 0;
            }
            aIndex--;
        }
        while (bIndex>=0){
            int numB = (int)b.charAt(bIndex)-(int)('0');
            if ((numB+temp)==2){
                temp = 1;
                stringBuilder.append("0");
            }else {
                stringBuilder.append((numB + temp)+"");
                temp = 0;
            }
            bIndex--;
        }
        if (temp==1){
            stringBuilder.append("1");
        }
//        System.out.println(stringBuilder.reverse().toString());
        return stringBuilder.reverse().toString();
    }
}