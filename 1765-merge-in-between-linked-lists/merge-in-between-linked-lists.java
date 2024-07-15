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

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp = list1;
        while(a>1 && temp != null){
            temp = temp.next;
            a--;
            b--;
        }
        if(temp == null)return list2;
        ListNode temp2 = temp;
        while(b >= 1 && temp2 != null){
            temp2 = temp2.next;
            b--;
        }
        ListNode tail = list2;
        while(tail.next != null)tail = tail.next;
        
        temp.next = list2;
        tail.next = temp2.next;
        return list1;
    }
}