package cn.lilq.question24;

import java.util.Stack;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/13 10:22
 */


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    ListNode res = null;
    private ListNode util(ListNode headNew,Stack<ListNode> stack){
        if (stack.size()==1 && headNew==null){
            headNew = stack.pop();
            res = headNew;
            if (headNew.next!=null)
                headNew.next=null;
            return headNew;
        } else if (headNew==null){
            headNew = stack.pop();
            res = headNew;
            headNew.next = stack.pop();
            if (headNew.next.next!=null)
                headNew.next.next=null;
            return headNew.next;
        } else if (stack.size()==1){
            headNew.next = stack.pop();
            if (headNew.next.next!=null)
                headNew.next.next=null;
            return headNew.next;
        }else {
            headNew.next = stack.pop();
            headNew = headNew.next;
            headNew.next = stack.pop();
            if (headNew.next.next!=null)
                headNew.next.next=null;
            return headNew.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode headNew = null;
        ListNode tempNode = head;
        Stack<ListNode> stack = new Stack<>();
        while (tempNode!=null){
            stack.push(tempNode);
            tempNode = tempNode.next;
            if (stack.size()==2){
                headNew = util(headNew,stack);
//                System.out.println(res);
            }
        }
        if (stack.size()>0){
            util(headNew,stack);
        }
        return res;
    }
}
