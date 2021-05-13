package cn.lilq.question25;

import java.util.Stack;

/**
 * @auther: Li Liangquan
 * @date: 2021/5/13 11:09
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

    /**
     * 反转
     * @param headNew
     * @param stack
     * @return
     */
    private ListNode utilReversal(ListNode headNew, Stack<ListNode> stack){
        if (headNew==null){
            headNew = stack.pop();
            res = headNew;
        }
        int count = stack.size();
        for (int i = 0; i < count; i++) {
            headNew.next = stack.pop();
            if (headNew.next.next!=null)
                headNew.next.next=null;
            headNew = headNew.next;
        }
        return headNew;
    }

    /**
     * 不反转 保持原顺序
     * @param headNew
     * @param stack
     */
    private void utilUnchange(ListNode headNew, Stack<ListNode> stack) {
        int count = stack.size();
        Stack<ListNode> stackNew = new Stack<>();
        for (int i = 0; i < count; i++) {
            stackNew.push(stack.pop());
        }
        int count2 = stackNew.size();
        if (headNew==null){
            headNew = stackNew.pop();
            res = headNew;
            count2--;
        }
        for (int i = 0; i < count2; i++) {
            headNew.next = stackNew.pop();
            if (headNew.next.next!=null)
                headNew.next.next=null;
            headNew = headNew.next;
        }
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode headNew = null;
        ListNode tempNode = head;
        Stack<ListNode> stack = new Stack<>();
        while (tempNode!=null){
            stack.push(tempNode);
            tempNode = tempNode.next;
            if (stack.size()==k){
                headNew = utilReversal(headNew,stack);
//                System.out.println(res);
            }
        }
        if (stack.size()>0){
            utilUnchange(headNew,stack);
//            System.out.println(res);
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution =  new Solution();
        ListNode listNode = new ListNode();
        listNode.val = 1;
        listNode.next = new ListNode();
        listNode.next.val = 2;
        listNode.next.next = new ListNode();
        listNode.next.next.val = 3;
        listNode.next.next.next = new ListNode();
        listNode.next.next.next.val = 4;
        listNode.next.next.next.next = new ListNode();
        listNode.next.next.next.next.val = 5;
        System.out.println(listNode);
        ListNode res = solution.reverseKGroup(listNode,7);
        System.out.println(res);
    }
}
