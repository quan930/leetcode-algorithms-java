package cn.lilq.question54;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/18 18:32
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int min = Math.min(matrix.length, matrix[0].length);
        if (min%2==1){
            min++;
        }

        int up,down,left,right;
        for (int i = 0; i < min/2; i++) {
            up = i;
            down = matrix.length-1-i;
            left = i;
            right = matrix[0].length-i-1;
//            System.out.println("up=" + up + ", down=" + down + ", left=" + left + ", right=" + right );
            //todo 向右
            for (int j = left; j <= right; j++) {
                res.add(matrix[up][j]);
            }
            if (up==down){
                return res;
            }
            //todo 向下
            for (int j = up+1; j <= down; j++) {
                res.add(matrix[j][right]);
            }
            if (left==right){
                return res;
            }
            //todo 向左
            for (int j = right-1; j >= left; j--) {
                res.add(matrix[down][j]);
            }
            //todo 向上
            for (int j = down-1; j > up; j--) {
                res.add(matrix[j][left]);
            }
        }
        return res;
    }
}
