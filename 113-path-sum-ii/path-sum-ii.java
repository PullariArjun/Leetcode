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
    List<Integer> lst = new ArrayList<>();
    List<List<Integer>> ans;
    int len = -1;
    public void fun(TreeNode root, int target, int sum){
        if(root == null)return;
        if(root.left == null && root.right == null){
            if(sum + root.val == target){
                lst.add(root.val);
                ans.add(new ArrayList<>(lst));
                lst.remove(len+1);
            }
            return;
        }
        lst.add(root.val);
        len++;
        fun(root.left, target, sum+root.val);
        fun(root.right, target, sum+root.val);
        lst.remove(len);
        len--;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        fun(root, targetSum, 0);
        return ans;
    }
}