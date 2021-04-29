package app.mrquan.heapsort;

import java.util.Random;

/**
 * @auther: Li Liangquan
 * @date: 2021/4/29 19:31
 */
public class Test {
    public static void main(String[] args) {
        // write your code here
        Heap heap = new Heap();
        heap.init(20);
        for (int i = 0; i < 20; i++) {
            heap.add(new Random().nextInt(50));
        }
        for (int i = 0; i < 20; i++) {
            int min = heap.get();
            System.out.print(min+"\t");
        }
    }
}
