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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head.next, trav = head.next.next;
        while(trav.next != null){
            if(trav.val == 0){
                temp.next = trav;
                temp = temp.next;
            }else{
                temp.val += trav.val;
            }
            trav = trav.next;
        }
        temp.next = null;
        return head.next;
    }
}