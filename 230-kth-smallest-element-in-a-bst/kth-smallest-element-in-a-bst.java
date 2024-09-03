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
    int x = 1, ans = -1;
    public void f(TreeNode root, int k){
        if(root == null)return;
        f(root.left, k);
        if(x == k)ans = root.val;
        x++;
        f(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        x = 1;
        ans = -1;
        f(root, k);
        return ans;
    }
}