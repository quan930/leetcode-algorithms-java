package cn.lilq.question61;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/25 11:38
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode temp = head;
        List<ListNode> listNodes = new ArrayList<>();
        while (temp!=null){
            listNodes.add(temp);
            temp = temp.next;
        }
        //
        k = k%listNodes.size();
        if (k==0){
            return head;
        }
        head = listNodes.get(listNodes.size()-k);
        listNodes.get(listNodes.size()-1).next = listNodes.get(0);
        listNodes.get(listNodes.size()-k-1).next = null;
        return head;
    }
}
