package app.mrquan.question11;

/**
 * @auther: Li Liangquan
 * @date: 2019/11/5 23:19
 * 11 Container With Most Water 盛最多水的容器
 * 根据题意 相当于找最大矩形面积 暴力破解
 */
public class Solution {
    public int maxArea(int[] height) {
        if (height.length<2) return -1;
        int max=0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                max =  Math.max(Math.min(height[i],height[j])*(j-i),max);
            }
        }
        return max;
    }
}
