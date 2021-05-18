package cn.lilq.question45;

import java.io.Serializable;
import java.nio.file.Path;
import java.util.*;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/17 23:38
 */
public class Solution {

    class Path{
        int index;//当前index
        int lens;//步数

        public Path(int index, int lens) {
            this.index = index;
            this.lens = lens;
        }


        @Override
        public String toString() {
            return "Path{" +
                    "index=" + index +
                    ", lens=" + lens +
                    '}';
        }
    }

    private int[] nums;


    private int backTrack(){
        Queue<Path> queue = new ArrayDeque<>();
        queue.offer(new Path(0,0));
        List<Integer> nodes = new ArrayList<>();
        int len=0;
        while (queue.peek()!=null){
            Path path = queue.poll();
            //todo 切除步长 一样 且index重复的点
            if (len==path.lens){
                if (nodes.contains(path.index)){
                    continue;
                } else{
                    nodes.add(path.index);
                }
            }else {
                len = path.lens;
                nodes.clear();
            }
            if (path.index == nums.length-1){
                System.out.println("结果:"+path);
                return path.lens;
            }
            if (path.index >= nums.length)
                continue;
            if (nums[path.index] == 0){
                continue;
            }
            for (int i = nums[path.index]; i > 0; i--) {
                queue.offer(new Path(path.index+i,path.lens+1));
            }
        }
        return -1;
    }

    public int jump(int[] nums) {
        this.nums = nums;
        return backTrack();
    }
}
