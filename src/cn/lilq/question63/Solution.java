package cn.lilq.question63;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/25 14:55
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j]==1){
                    obstacleGrid[i][j]=-1;
                }
            }
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0]!=-1){
                obstacleGrid[i][0] = 1;
            }else{
                break;
            }
        }
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] != -1){
                obstacleGrid[0][i] = 1;
            }else{
                break;
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j]==-1){
                    obstacleGrid[i][j] = 0;
                }else if (obstacleGrid[i-1][j]==-1 && obstacleGrid[i][j-1]==-1){
                    obstacleGrid[i][j] = 0;

                }else if (obstacleGrid[i-1][j]==-1){
                    obstacleGrid[i][j] = obstacleGrid[i][j-1];
                }else if (obstacleGrid[i][j-1]==-1){
                    obstacleGrid[i][j] = obstacleGrid[i-1][j];
                }else {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==-1?0:obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
