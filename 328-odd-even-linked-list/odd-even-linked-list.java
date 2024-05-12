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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode ans = new ListNode(0), temp = head, trav = ans;
        while(temp != null){
            trav.next = new ListNode(temp.val);
            trav = trav.next;
            temp = temp.next;
            if(temp != null)temp = temp.next;
        }
        temp = head.next;
        while(temp != null){
            trav.next = new ListNode(temp.val);
            trav = trav.next;
            temp = temp.next;
            if(temp != null)temp = temp.next;
        }
        return ans.next;

    }
}