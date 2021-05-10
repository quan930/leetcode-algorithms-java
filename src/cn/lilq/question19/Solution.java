package cn.lilq.question19;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/10 22:52
 */
public class Solution {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode = head;
        List<ListNode> list = new ArrayList<>();
        while (listNode!=null){
            list.add(listNode);
            listNode = listNode.next;
        }
        if (n==list.size()){
            assert head != null;
            if (head.next==null)
                return null;
            else
                return head.next;
        }
        if (n==1){
            list.get(list.size()-2).next = null;
            return head;
        }
        list.get(list.size()-n-1).next = list.get(list.size()-n+1);
        return head;
    }
}
