package cn.lilq.question43;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/16 20:51
 */
public class Solution {
    private int sum (char m,char n){
        return Integer.parseInt(m+"") * Integer.parseInt(n+"");
    }


    public String multiply(String num1, String num2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = num1.length()-1,countI = 0; i >= 0; i--,countI++) {
            for (int j = num2.length()-1,countJ = 0; j >= 0; j--,countJ++) {
                if (map.get(countI+countJ) == null){
                    map.put(countI+countJ,sum(num1.charAt(i),num2.charAt(j)));
                }else {
                    map.put(countI+countJ,map.get(countI+countJ)+sum(num1.charAt(i),num2.charAt(j)));
                }
            }
        }
        for (int i = 0; i < map.keySet().size()-1; i++) {
            int value = map.get(i);
            map.put(i,value%10);
            map.put(i+1,value/10+map.get(i+1));
        }

//        System.out.println(map);
        StringBuilder stringBuilder = new StringBuilder();
        int start = map.keySet().size();
        for (int i = map.keySet().size()-1; i >= 0; i--) {
            if (map.get(i)==0){
                start--;
            }else {
                break;
            }
        }
        for (int i = start-1; i >= 0; i--) {
            stringBuilder.append(map.get(i));
        }
        return stringBuilder.length()==0?"0":stringBuilder.toString();
    }
}
