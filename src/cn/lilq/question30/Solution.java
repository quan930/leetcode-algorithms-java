package cn.lilq.question30;

import java.util.*;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/14 11:26
 */
class Solution {
    int length;
    int maxLength;

    private boolean searchList(Map<String,Integer> map,int index,String s){
        // System.out.println("map"+map+"\tindex:"+index+"\ts:"+s);
        if (map.isEmpty())
            return true;
        Integer count = map.get(s.substring(index,index+length));
        if (count==null)
            return false;
        else {
            if (count==1){
                map.remove(s.substring(index,index+length));
            }else {
                map.put(s.substring(index,index+length),count-1);
            }
            return searchList(map,index+length,s);
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.get(words[i])==null)
                map.put(words[i],1);
            else
                map.put(words[i],map.get(words[i])+1);
        }
        length = words[0].length();
        maxLength = length*words.length;
        // System.out.println(length);
        // System.out.println(maxLength);
        // System.out.println("map:"+map);

        for (int i = 0; i <= s.length()-maxLength; i++) {
            Integer count = map.get(s.substring(i,i+length));
            if (count != null){
                HashMap<String, Integer> hmCopy = new HashMap(map);
                //判断是否需要移除
                if (count==1){
                    hmCopy.remove(s.substring(i,i+length));
                }else {
                    hmCopy.put(s.substring(i,i+length),count-1);
                }

                //todo 滑动窗口判断

                // System.out.println(hmCopy);
                // System.out.println("可以查询："+s.substring(i,i+length));
                boolean b = searchList(hmCopy,i+length,s);
                if (b){
                    res.add(i);
                }
            }
        }
        return res;
    }
}