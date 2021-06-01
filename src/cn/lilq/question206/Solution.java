package cn.lilq.question206;

import java.util.Stack;

/**
 * @auther: Li Liangquan
 * @date: 2021/6/1 22:36
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        Stack<ListNode> listNodes = new Stack<>();
        while (head!=null){
            listNodes.push(head);
            head = head.next;
        }
        ListNode newHead = listNodes.pop();
        ListNode temp = newHead;
        while (!listNodes.empty()){
            temp.next = listNodes.pop();
            temp = temp.next;
        }
        temp.next = null;
        return newHead;
    }
}
