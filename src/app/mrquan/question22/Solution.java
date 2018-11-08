package app.mrquan.question22;

import java.util.Stack;

/**
 * 22 括号匹配
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
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
