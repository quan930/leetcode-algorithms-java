package cn.lilq.question3;

import java.util.*;

/**
 * 3.无重复字符的最长子串
 * longest substring without repeating characters
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int max = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (!list.contains(array[i])) {
                list.add(array[i]);
//                System.out.println(list);
            }else {
                max= (max<list.size()?list.size():max);
                //获取索引
                int remove = list.indexOf(array[i]);
                //获取要删除的数组
                List<Character> characters = new ArrayList<>();
                for (int j = 0; j <= remove; j++) {
                    characters.add(list.get(j));
                }
                //删除重复数组
                list.removeAll(characters);
                //加入数组
                list.add(array[i]);
            }
        }
        return max<list.size()?list.size():max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
