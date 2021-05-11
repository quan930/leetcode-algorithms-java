package cn.lilq.question21;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/11 09:33
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null&&l2==null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode listNode,head;
        if (l1.val < l2.val){
            listNode = l1;
            l1 = l1.next;
        }else {
            listNode = l2;
            l2 = l2.next;
        }
        head = listNode;
        while (l1!=null && l2!=null){
            if (l1.val < l2.val){
                listNode.next = l1;
                l1 = l1.next;
            }else {
                listNode.next = l2;
                l2 = l2.next;
            }
            listNode = listNode.next;
        }
        while (l1!=null){
            listNode.next = l1;
            l1 = l1.next;
            listNode = listNode.next;
        }
        while (l2!=null){
            listNode.next = l2;
            l2 = l2.next;
            listNode = listNode.next;
        }
        return head;
    }
}
