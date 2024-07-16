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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ListNode getMid(ListNode head){
        if(head == null)return null;
        if(head.next == null)return head;
        ListNode slow = head, fast = head.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    TreeNode buildTree(ListNode head, ListNode tail){
        if(head == null)return null;
        if(head == tail)return new TreeNode(head.val);
        ListNode mid = getMid(head);
        TreeNode root = new TreeNode(mid.next.val);
        ListNode x = mid.next.next;
        mid.next = null;
        root.left = buildTree(head, mid);
        root.right = buildTree(x, tail);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)return null;
        ListNode tail = head;
        while(tail.next != null)tail = tail.next;
        return buildTree(head, tail);
    }
}