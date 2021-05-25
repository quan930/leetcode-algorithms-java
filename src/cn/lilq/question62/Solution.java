package cn.lilq.question62;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/25 14:11
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(arr[i][j]+"\t");
//            }
//            System.out.println();
//        }
        return arr[m-1][n-1];
    }
}
