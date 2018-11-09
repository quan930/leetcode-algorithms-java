package app.mrquan.question85;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        System.out.println(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
        return 0;
    }

    public static void main(String[] args) {
        new Solution().maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
    }
}
