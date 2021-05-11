package cn.lilq.question23;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/11 14:27
 */

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < lists.length; i++) {
            while (lists[i]!=null){
                priorityQueue.offer(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        ListNode listNode = new ListNode();
        ListNode head = listNode;

        if (priorityQueue.isEmpty()){
            return null;
        }

        while (priorityQueue.peek()!=null){
            ListNode temp = priorityQueue.poll();
            listNode.val = temp.val;
            listNode.next = priorityQueue.peek();
            listNode = listNode.next;
        }
        return head;
    }
}
