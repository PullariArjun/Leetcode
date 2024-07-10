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


    public ListNode merge(ListNode node1, ListNode node2){
        if(node1 == null)return node2;
        if(node2 == null)return node1;
        ListNode temp1 = node1, temp2 = node2;
        while(temp2 != null && temp1.val > temp2.val){
            ListNode x = temp2.next;
            temp2.next = temp1;
            temp1 = temp2;
            node1 = temp2;
            temp2 = x;
        }
        if(temp2 == null)return node1;

        while(temp1.next != null && temp2 != null){
            if(temp1.next.val >= temp2.val){
                ListNode x = temp2.next;
                temp2.next = temp1.next;
                temp1.next = temp2;
                temp2 = x;
            }else{
                temp1 = temp1.next;
            }
        }
        if(temp2 == null)return node1;
        if(temp1.next == null)temp1.next = temp2;
        return node1;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)return null;
        if(lists.length == 1)return lists[0];
        for(int i = 1; i < lists.length; i++){
            lists[0] = merge(lists[0], lists[i]);
        }
        return lists[0];
        
    }
}