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

    boolean ans = true;
    public int fun(TreeNode root){
        if(root == null)return 0;
        int x = fun(root.left);
        int y = fun(root.right);

        if(Math.abs(x- y) > 1)ans = false;
        return 1 + Math.max(x ,y);
        
    }
    public boolean isBalanced(TreeNode root) {
        ans = true;
        fun(root);
        return ans;

        
    }
}