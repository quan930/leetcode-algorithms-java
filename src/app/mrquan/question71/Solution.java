package app.mrquan.question71;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 你是否考虑了 路径 = "/../" 的情况？
 * 在这种情况下，你需返回 "/" 。
 * 此外，路径中也可能包含多个斜杠 '/' ，如 "/home//foo/" 。
 * 在这种情况下，你可忽略多余的斜杠，返回 "/home/foo"
 *      /.. => /
 *      // => /
 *
 *  根据'/'进行拆分
 *  去除"/./"和 "//"
 *  判断 "/../"弹栈
 *  正常数据压栈
 *
 *  结果为 "/"+String
 *  并判断 size是否为0 如果为0 路径为"/"
 */
public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] array = path.split("/");
        StringBuilder stringBuilder = new StringBuilder();
        for (String anArray : array) {
            switch (anArray) {
                case ".":
                case "":
                    break;
                case "..":
                    if (!stack.empty())
                        stack.pop();
                    break;
                default:
                    stack.push(anArray);
                    break;
            }
        }
        for (int i = 0; i < stack.size(); i++) {
            stringBuilder.append("/"+stack.get(i));
        }
        if (stack.size()==0){
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/Users/daquan/.././/asd/c//qwer/."));
    }
}
