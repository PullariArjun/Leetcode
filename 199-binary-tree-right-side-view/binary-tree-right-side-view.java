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
    int max = 0;
    public void fun(TreeNode root, List<Integer> ans, int depth){
        if(root == null)return;
        if(depth > max){
            ans.add(root.val);
            max = Math.max(depth, max);
        }
        fun(root.right, ans, depth+1);
        fun(root.left, ans, depth+1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        max = 0;
        fun(root, ans,1);
        return ans;
    }
}