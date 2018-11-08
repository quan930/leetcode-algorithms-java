package app.mrquan.question22;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.toCharArray()[i];
            if (c=='('||c=='['||c=='{')
                stack.push(c);
            if (c==')'||c==']'||c=='}'){
                if (stack.empty())
                    return false;
                char character = stack.pop();
                if (c==')'&&character != '(')
                    return false;
                if (c==']'&&character != '[')
                    return false;
                if (c=='}'&&character != '{')
                    return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("{{()()[]}}"));
    }
}
