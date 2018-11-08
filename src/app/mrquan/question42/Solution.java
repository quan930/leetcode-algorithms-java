package app.mrquan.question42;

import java.util.Stack;

public class Solution {
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int left=-1;
        for (int i = 0; i < height.length; i++) {
            if (stack.empty()){//null
                left = height[i];
                stack.push(height[i]);
            }else {
                if (left>height[i]){
                    stack.push(height[i]);
                }else {
                    stack.push(height[i]);
                    sum+=sum(left,stack);
                    stack.clear();
                    stack.push(height[i]);
                    left = height[i];
                }
            }
        }
        if (!stack.empty()){
            int right = stack.pop();//右高度
            while (!stack.empty()){
                if (right<stack.peek())
                    right = stack.pop();
                else {
                    sum += right-stack.pop();
                }
            }
        }
        return sum;
    }
    private int sum(int left,Stack<Integer> stack){
        int sum = 0;
//        System.out.println("最小"+left);
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i)>left){
                break;
            }
            sum = sum+((left-stack.get(i)));
        }
        return sum;
    }

    public static void main(String[] args) {
        new Solution().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
