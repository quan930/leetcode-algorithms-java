package cn.lilq.question49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/18 12:46
 */
public class Solution {
    List<List<String>> res;
    List<Map<Character,Integer>> listMap;

    int findIndex(String str){
        Map<Character,Integer> map = getMap(str);
        for (int i = 0; i < listMap.size(); i++) {
            if (map.equals(listMap.get(i)))
                return i;
        }
        listMap.add(map);
        return listMap.size()-1;
    }

    private Map<Character,Integer> getMap(String str){
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.merge(str.charAt(i), 1, Integer::sum);
        }
        return map;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        res = new ArrayList<>();
        listMap = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            int index = findIndex(strs[i]);
            if (index >= res.size()){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                res.add(list);
            }else {
                res.get(index).add(strs[i]);
            }
        }
        return res;
    }
}
