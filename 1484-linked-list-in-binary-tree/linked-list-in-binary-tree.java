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
    // ListNode node;

    public boolean check(TreeNode root, ListNode head){
        if(head == null)return true;
        if(root == null)return false;
        if(head.val == root.val){
            return check(root.left, head.next) || check(root.right, head.next);
        }
        return false;

    }
    public boolean fun(TreeNode root, ListNode head){
        if(root == null)return false;
        if(root.val == head.val){
            if(check(root, head))return true;
        }
        return fun(root.left, head) || fun(root.right, head);
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        return fun(root, head);
    }
}