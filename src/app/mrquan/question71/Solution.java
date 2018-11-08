package app.mrquan.question71;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 71简化路径
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
