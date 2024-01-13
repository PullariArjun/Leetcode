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
    public int getLevel(TreeNode root, int depth){
        if(root == null)return depth;
        return Math.max(getLevel(root.left, depth+1), getLevel(root.right, depth+1));
    }
    public int getSum(TreeNode root, int depth, int level){
        if(root == null)return 0;
        if(depth == level) return root.val;
        return getSum(root.left, depth, level+1) + getSum(root.right, depth, level+1);

    }
    public int deepestLeavesSum(TreeNode root) {
        return getSum(root, getLevel(root, 0), 1);
    }
}