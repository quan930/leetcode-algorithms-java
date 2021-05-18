package cn.lilq.question48;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/18 11:05
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int temp;
        for (int i = 0; i < length/2; i++) {
            //todo 圈数
            for (int j = 0; j < length-i*2-1; j++) {
//                System.out.print(matrix[i][j+i]+"\t");
//                System.out.print(matrix[i+j][length-i-1]+"\t");
//                System.out.print(matrix[length-i-1][length-j-1-i]+"\t");
//                System.out.print(matrix[length-j-1-i][i]+"\t");
//                System.out.println();
                //todo 交换1
                temp = matrix[i][j+i];
                matrix[i][j+i] = matrix[i+j][length-i-1];
                matrix[i+j][length-i-1] = temp;
                //todo 交换2
                temp = matrix[i][j+i];
                matrix[i][j+i] = matrix[length-i-1][length-j-1-i];
                matrix[length-i-1][length-j-1-i] = temp;
                //todo 交换3
                temp = matrix[i][j+i];
                matrix[i][j+i] = matrix[length-j-1-i][i];
                matrix[length-j-1-i][i] = temp;
            }
//            System.out.println();
        }
    }

    private void print(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
