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
    int maxSum = 0;
    public void fun(TreeNode root){
        if(root == null)return;
        fun(root.right);
        maxSum += root.val;
        root.val = maxSum;
        fun(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        fun(root);
        return root;
    }
}