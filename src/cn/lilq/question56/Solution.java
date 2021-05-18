package cn.lilq.question56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/18 20:50
 */
public class Solution {
    static class Region{
        Integer min;
        Integer max;

        public Region(int num1, int num2) {
            max = Math.max(num1,num2);
            min = Math.min(num1, num2);
        }

        public boolean merge(int num1,int num2){
            int min = Math.min(num1, num2);
            int max = Math.max(num1, num2);
            if (min>this.max || max<this.min){
                return false;
            }
            this.min = Math.min(min,this.min);
            this.max = Math.max(this.max,max);
            return true;
        }

        @Override
        public String toString() {
            return "Region{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new int[]{intervals[i][0],intervals[i][1]});
        }

        list.sort(Comparator.comparingInt(o -> o[0]));


        List<Region> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            boolean isOk = false;
            for (int j = 0; j < res.size(); j++) {
                if (res.get(j).merge(list.get(i)[0],list.get(i)[1])){
                    isOk = true;
                    break;
                }
            }
            if (!isOk){
                res.add(new Region(list.get(i)[0],list.get(i)[1]));
            }
        }
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i][0] = res.get(i).min;
            result[i][1] = res.get(i).max;
        }
        return result;
    }
}
