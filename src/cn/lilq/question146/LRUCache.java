package cn.lilq.question146;

import java.util.*;

/**
 * @auther: Li Liangquan
 * @date: 2021/6/1 23:05
 */
public class LRUCache {
    long count = 0;
    class Cache{
        int key;
        int value;
        long active;

        public Cache(int key, int value) {
            this.key = key;
            this.value = value;
            count++;
            this.active = count;
        }

        @Override
        public String toString() {
            return "Cache{" +
                    "key=" + key +
                    ", value=" + value +
                    ", active=" + active +
                    '}';
        }
    }

    private int capacity;
    private PriorityQueue<Cache> priorityQueue;
    private Map<Integer,Cache> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.priorityQueue = new PriorityQueue<>(Comparator.comparingLong(o -> o.active));
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.get(key)==null){
            return -1;
        }else {
            int value = map.get(key).value;
            priorityQueue.remove(map.get(key));
            count++;
            map.get(key).active = count;
            priorityQueue.offer(map.get(key));
            return value;
        }
    }

    public void put(int key, int value) {
        if (map.get(key)!=null){
            priorityQueue.remove(map.get(key));
            count++;
            map.get(key).active = count;
            map.get(key).value = value;
            priorityQueue.offer(map.get(key));
            return;
        }

        if (priorityQueue.size()>=capacity){
            Cache cache = priorityQueue.poll();
            assert cache != null;
            map.remove(cache.key);
        }
        Cache cache = new Cache(key,value);
        priorityQueue.offer(cache);
        map.put(key,cache);
    }

    public void str(){
        System.out.println(priorityQueue);
    }

    public static void main(String[] args) throws InterruptedException {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,6);
        lruCache.get(1);


        lruCache.put(1,5);
        lruCache.str();
    }
}
