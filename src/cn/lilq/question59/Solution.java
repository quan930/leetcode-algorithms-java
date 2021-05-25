package cn.lilq.question59;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/25 09:22
 */
public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = 0;
            }
        }
        int x = 0;
        int y = 0;
        int count=1;
        res[x][y]=count;
        y++;
        while (true){
            //todo 向右
            for (int i = y; i < n; i++,y++) {
                if (res[x][i] == 0){
                    count++;
                    res[x][i]=count;
                }else {
                    break;
                }
            }
            if (count==n*n){
                return res;
            }
            y--;x++;
            //todo 向下
            for (int i = x; i < n; i++,x++) {
                if (res[i][y] == 0){
                    count++;
                    res[i][y]=count;
                }else {
                    break;
                }
            }
            if (count==n*n){
                return res;
            }
            //todo 向左
            y--;x--;
            for (int i = y; i >= 0; i--,y--) {
                if (res[x][i] == 0){
                    count++;
                    res[x][i]=count;
                }else {
                    break;
                }
            }
            if (count==n*n){
                return res;
            }
            //todo 向上
            y++;x--;
            for (int i = x; i >= 0; i--,x--) {
                if (res[i][y] == 0){
                    count++;
                    res[i][y]=count;
                }else {
                    break;
                }
            }
            if (count==n*n){
                return res;
            }
            x++;y++;
        }
    }
}
