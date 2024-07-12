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
    TreeNode ans, temp;
    void fun(TreeNode root){
        if(root == null)return;
        temp.right = new TreeNode(root.val);
        temp = temp.right;
        fun(root.left);
        fun(root.right);
    }
    public void flatten(TreeNode root) {
        if(root == null)return;
        if(root.left == null && root.right == null)return;
        ans = new TreeNode();
        temp = ans;
        fun(root);
        root.right = ans.right.right;
        root.left = null;
    }
}