package cn.lilq.question44;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/17 13:56
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, iStarIndex = -1, jStarIndex = -1;
        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                ++i; ++j;
            } else if (j < p.length() && p.charAt(j) == '*') {
                iStarIndex = i;
                jStarIndex = j++;
            } else if (iStarIndex >= 0) {
                i = ++iStarIndex;
                j = jStarIndex + 1;
            } else return false;
        }
        while (j < p.length() && p.charAt(j) == '*') ++j;
        return j == p.length();
    }
}