package cn.lilq.question82;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2021/6/21 16:39
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        List<Integer> list = new ArrayList<>();
        int temp = head.val;
        list.add(head.val);
        head = head.next;
        while (head!=null){
            if (head.val != temp){
                list.add(head.val);
                temp = head.val;
            }else{
                int finalTemp = temp;
                list.removeIf(integer -> finalTemp ==integer);
            }
            head = head.next;
        }
//        System.out.println(list);
        if (list.size()>0){
            ListNode headNew = new ListNode(list.get(0));
            ListNode res = headNew;
            for (int i = 1; i < list.size(); i++) {
                headNew.next = new ListNode(list.get(i));
                headNew = headNew.next;
            }
            return res;
        }else {
            return null;
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
