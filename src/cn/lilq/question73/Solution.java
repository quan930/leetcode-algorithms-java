package cn.lilq.question73;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/6/15 20:10
 */
class Solution {
    class Position{
        private int i;
        private int j;

        public Position(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public void util(Position position,int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][position.j] = 0;
        }
        Arrays.fill(matrix[position.i], 0);
    }
    public void setZeroes(int[][] matrix) {
        List<Position> temp = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]==0){
                    temp.add(new Position(i,j));
                }
            }
        }
        for (int i = 0; i < temp.size(); i++) {
            util(temp.get(i),matrix);
        }
    }
}
