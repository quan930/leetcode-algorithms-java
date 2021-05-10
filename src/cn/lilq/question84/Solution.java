package cn.lilq.question84;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int temp;
        for (int i = 0; i <heights.length ; i++) {
            temp = max(i,heights);
            if (temp>max){
                max = temp;
            }
        }
        return max;
    }
    private int max(int position,int[] heights){
        int sum = 0;
        int height = heights[position];
        sum = height;
        int newPosition=position-1;
        while (true){
            if (newPosition<0){
                break;
            } else if (height>heights[newPosition]){
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
            } else if (height>heights[newPosition]){
                break;
            } else {
                sum += height;
                newPosition++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
