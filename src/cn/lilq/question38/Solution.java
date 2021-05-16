package cn.lilq.question38;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/16 14:28
 */
public class Solution {
    public String countAndSay(int n) {
        String mm = "1";
        for (int i = 1; i < n; i++) {
            mm = compression(mm);
        }
        return mm;
    }

    /**
     * 压缩
     * @param m 原来字符串
     * @return 新字符串
     */
    public String compression(String m){
        StringBuilder stringBuilder = new StringBuilder();
        Character p = null;
        int count = 0;
        for (int i = 0; i < m.length(); i++) {
            if (p==null){
                p = m.charAt(i);
                count++;
                continue;
            }
            if (p.equals(m.charAt(i))){
                count++;
            }else {
                stringBuilder.append(count);
                stringBuilder.append(p);
                p = m.charAt(i);
                count=1;
            }
        }
        if (count!=0){
            stringBuilder.append(count);
            stringBuilder.append(p);
        }
        return stringBuilder.toString();
    }
}
