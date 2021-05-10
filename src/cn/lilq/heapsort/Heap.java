package cn.lilq.heapsort;

/**
 * @auther: Li Liangquan
 * @date: 2021/4/29 19:31
 */
public class Heap {
    private int[] heap;
    private int size=0;
    public void init(int length){
        heap = new int[length+1];
    }

    public void add(int number){
        heap[size] = number;
        checkoutUp(size);
        size++;
//        System.out.println(Arrays.toString(heap));
    }

    public int get(){
        int min = heap[0];
        heap[0] = heap[size-1];
        heap[size-1] = 0;
        size--;
        checkoutDown(0);
//        System.out.println(Arrays.toString(heap));
        return min;
    }

    private void checkoutDown(int index) {
//        System.out.println("index:"+index);
        if (index*2>size)
            return;
        if (heap[(index+1)*2-1]==0 && heap[(index+1)*2]==0){
            return;
        }else if (heap[(index+1)*2]==0){
            if (heap[(index+1)*2-1]<=heap[index]){
                int temp = heap[(index+1)*2-1];
                heap[(index+1)*2-1] = heap[index];
                heap[index] = temp;
            }
            return;
        }else if (heap[index]<=heap[(index+1)*2-1] && heap[index]<=heap[(index+1)*2]){
            return;
        }else if (heap[(index+1)*2-1]<=heap[index] && heap[(index+1)*2-1]<=heap[(index+1)*2]){
            int temp = heap[(index+1)*2-1];
            heap[(index+1)*2-1] = heap[index];
            heap[index] = temp;
            checkoutDown((index+1)*2-1);
        }else{
            int temp = heap[(index+1)*2];
            heap[(index+1)*2] = heap[index];
            heap[index] = temp;
            checkoutDown((index+1)*2);
        }
    }

    private void checkoutUp(int index) {
        if (index==0)
            return;
        if (heap[(index+1)/2-1]<heap[index]){
            return;
        }else {
//            heap[size/2-1]<heap[size]
            int temp = heap[(index+1)/2-1];
            heap[(index+1)/2-1] = heap[index];
            heap[index] = temp;
            checkoutUp((index+1)/2-1);
        }
    }
}

