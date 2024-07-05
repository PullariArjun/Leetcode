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
    public int getmin(ListNode head){
        ListNode temp = head;
        int ans = Integer.MAX_VALUE, trav = 1;
        while(temp.next.next != null){
            if(temp.val < temp.next.val && temp.next.val > temp.next.next.val){
                ans = Math.min(trav, ans);
                trav = 1;
            }
            else if(temp.val > temp.next.val && temp.next.val < temp.next.next.val){
                ans = Math.min(trav, ans);
                trav = 1;
            }
            else trav++;
            temp = temp.next;
        }
        if(ans == Integer.MAX_VALUE)return -1;
        return ans;
    }
    public int getmax(ListNode head){
        ListNode temp = head;
        int ans = -1, trav = 1;
        while(temp.next.next != null){
            if(temp.val < temp.next.val && temp.next.val > temp.next.next.val){
                ans = Math.max(trav, ans);
            }
            else if(temp.val > temp.next.val && temp.next.val < temp.next.next.val){
                ans = Math.max(trav, ans);
            }
            trav++;
            temp = temp.next;
        }
        return ans;
    }
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null)return new int[]{-1,-1};
        ListNode temp = head;
        while(temp.next.next != null){
            if(temp.val < temp.next.val && temp.next.val > temp.next.next.val){
                break;
            }
            if(temp.val > temp.next.val && temp.next.val < temp.next.next.val){
                break;
            }
            temp = temp.next;
        }
        if(temp == null || temp.next == null)return new int[]{-1, -1};
        if(temp.next.next == null)return new int[]{-1, -1};
        return new int[]{getmin(temp.next), getmax(temp.next)};
    }
}