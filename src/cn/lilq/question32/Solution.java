package cn.lilq.question32;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/15 12:31
 */
public class Solution {
    private int getLength(String s){
        int left = 0;
        int right = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('){
                //todo (
                left++;
            }else {
                //todo )
                right++;
            }
            if (right>left)
                break;
            if (right==left){
                length += right+left;
                right = 0;
                left = 0;
            }
        }
        return length;
    }

    public int longestValidParentheses(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = getLength(s.substring(i));
//            System.out.println(s.substring(i));
//            System.out.println("temp"+temp);
//            System.out.println();
            if (temp>max){
                max = temp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int max = solution.longestValidParentheses("()(()");
        System.out.println(max);
    }
}
