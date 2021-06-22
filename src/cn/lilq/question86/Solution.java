package cn.lilq.question86;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/6/22 17:07
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head==null){
            return head;
        }
        if (head.next==null){
            return head;
        }
        List<Integer> min = new ArrayList<>();
        List<Integer> max = new ArrayList<>();
        while (head!=null){
            if (head.val<x){
                min.add(head.val);
            }else {
                max.add(head.val);
            }
            head = head.next;
        }
        if (min.size()==0){
            //todo min==0
            ListNode res = new ListNode(max.get(0));
            ListNode temp = res;
            for (int i = 1; i < max.size(); i++) {
                temp.next = new ListNode(max.get(i));
                temp = temp.next;
            }
            return res;
        }
        ListNode res = new ListNode(min.get(0));
        ListNode temp = res;
        for (int i = 1; i < min.size(); i++) {
            temp.next = new ListNode(min.get(i));
            temp = temp.next;
        }
        for (int i = 0; i < max.size(); i++) {
            temp.next = new ListNode(max.get(i));
            temp = temp.next;
        }
        return res;
    }


     //Definition for singly-linked list.
     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
