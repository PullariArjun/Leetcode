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
    public ListNode partition(ListNode head, int x) {
        ListNode temp = head;
        ListNode ans = null , node = null;
        while(temp != null){
            if(temp.val < x){
                ListNode newNode = new ListNode(temp.val);
                if(ans == null){
                    ans = newNode;
                    node = ans;
                }
                else{
                    node.next = newNode;
                    node = node.next;
                }
            }
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            if(temp.val >= x){
                ListNode newNode = new ListNode(temp.val);
                if(ans == null){
                    ans = newNode;
                    node = ans;
                }
                else{
                    node.next = newNode;
                    node = node.next;
                }
            }
            temp = temp.next;
        }
        System.gc();
        return ans;
    }
}