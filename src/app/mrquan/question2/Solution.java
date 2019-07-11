package app.mrquan.question2;

/**
 * 2.两数相加
 */
public class Solution {
    static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null&&l2==null){
            return null;
        }
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = listNode;
        int m = 0;
        while (l1!=null || l2!=null) {
            if (l1!=null){
                m = m + l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                m = m + l2.val;
                l2 = l2.next;
            }
            listNode1.next = new ListNode(m % 10);
            System.out.println("a"+m%10);
            m = m / 10;
            listNode1 = listNode1.next;
        }
        if (m>0) {
            listNode1.next = new ListNode(1);
        }
        return listNode.next;
    }

//    Definition for singly-linked list.
     public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
