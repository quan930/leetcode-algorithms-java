package cn.lilq.question74;

/**
 * @auther: Li Liangquan
 * @date: 2021/6/15 21:00
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int line = matrix.length;
        int row = matrix[line-1].length;
        if (target > matrix[line-1][row-1]){
            return false;
        }
        if (target < matrix[0][0])
            return false;

        for (int i = 0; i < line; i++) {
            if (target>matrix[i][row-1]){
                continue;
            }
            for (int j = 0; j < row; j++) {
                if (target==matrix[i][j]){
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
