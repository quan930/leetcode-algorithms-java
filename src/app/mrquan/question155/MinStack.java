package app.mrquan.question155;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 155 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */
public class MinStack {
    private List<Integer> list;

    public MinStack(){
        list = new ArrayList<>();
    }
    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        list.remove(list.size()-1);
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int getMin() {
        int min = list.get(0);
        for (Integer integer:list){
            if (integer<min){
                min = integer;
            }
        }
        return min;
    }
}
