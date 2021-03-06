package test;

/*
* You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*
* */
public class Test2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        int carry = 0;
        while(l1 != null && l2 != null){
            node.next = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;

        }
        l1 = l1 != null ? l1 : l2;

        while(l1 != null){
            node.next = new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            l1 = l1.next;
            node = node.next;
        }

        if(carry != 0)
            node.next = new ListNode(carry);
        return head.next;
    }
}
