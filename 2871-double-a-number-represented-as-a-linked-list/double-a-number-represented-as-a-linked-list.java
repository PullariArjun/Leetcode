/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int fun(ListNode head){
        if(head == null)return 0;
        int carry = fun(head.next);
        int sum = head.val * 2 + carry;
        carry = sum/10;
        head.val = sum%10;
        return carry;

    }
    public ListNode doubleIt(ListNode head) {
        int x = fun(head);
        if(x == 0)return head;
        ListNode node = new ListNode(1);
        node.next = head;
        return node;
    }
}