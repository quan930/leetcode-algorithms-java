package app.mrquan.question155;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
