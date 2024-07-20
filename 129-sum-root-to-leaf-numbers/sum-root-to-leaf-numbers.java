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
    int ans = 0, x = 0;
    void fun(TreeNode root){
        if(root == null)return;
        if(root.left == null && root.right == null){
            x = x * 10 + root.val;
            ans += x;
            x = x/ 10;
            return;
        }
        x = x * 10 + root.val;
        fun(root.left);
        fun(root.right);
        x = x / 10;
    }
    public int sumNumbers(TreeNode root) {
        x = ans = 0;
        fun(root);
        return ans;
    }
}