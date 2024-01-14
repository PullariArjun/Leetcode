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
    int getGCD(int n, int m){
        if(n == 0)return m;
        if(n > m)return getGCD(n-m, m);
        return getGCD(m-n, n);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        while(temp.next != null){
            ListNode node = new ListNode(getGCD(temp.val, temp.next.val));
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;
        }
        return head;
    }
}