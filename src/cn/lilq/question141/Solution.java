package cn.lilq.question141;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/6/2 10:49
 */
public class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        while (head!=null){
            if (listNodes.contains(head)){
                return true;
            }
            listNodes.add(head);
            head = head.next;
        }
        return false;
    }
}
