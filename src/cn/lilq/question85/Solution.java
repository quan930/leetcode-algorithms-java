package cn.lilq.question85;

public class Solution {
    private int max(int position,int column ,int[][] heights){
        int sum = 0;
        int height = heights[position][column];
        sum = height;
        int newPosition=position-1;
        while (true){
            if (newPosition<0){
                break;
            } else if (height>heights[newPosition][column]){
                break;
            }else {
                sum += height;
                newPosition--;
            }
        }
        newPosition=position+1;
        while (true){
            if (newPosition==heights.length){
                break;
            } else if (height>heights[newPosition][column]){
                break;
            } else {
                sum += height;
                newPosition++;
            }
        }
        return sum;
    }

    /**
     * 找到每指定列的最大矩形面积
     * @param column 列号
     * @param matrixInt 矩阵
     * @return 最大面积
     */
    private int findMax(int column,int[][] matrixInt){
        int max = 0;
        int temp;
        for (int i = 0; i <matrixInt.length ; i++) {
            temp = max(i,column,matrixInt);
            if (temp>max){
                max = temp;
            }
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length==0){
            return 0;
        }
        int res = 0;
        int[][] matrixInt = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            matrixInt[i][0] = matrix[i][0]=='0'?0:1;
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j]!='0'){
                    matrixInt[i][j] = matrixInt[i][j-1]+1;
                }else {
                    matrixInt[i][j]=0;
                }
            }
        }
        //todo 计算每一列的最大面积
        int temp;
        for (int i = 0; i < matrixInt[0].length; i++) {
            temp =  findMax(i,matrixInt);
            if (res<temp){
                res = temp;
            }
        }
        return res;
    }
}