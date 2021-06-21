package cn.lilq.question83;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/6/21 19:05
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            if (!list.contains(head.val)){
                list.add(head.val);
            }
            head = head.next;
        }
        if (list.size()>0){
            ListNode listNode = new ListNode(list.get(0));
            ListNode res = listNode;
            for (int i = 1; i < list.size(); i++) {
                listNode.next = new ListNode(list.get(i));
                listNode = listNode.next;
            }
            return res;
        }else {
            return head;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
