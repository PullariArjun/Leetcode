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
    public TreeNode construct(int[] arr, int start, int end){
        if(start == end)return new TreeNode(arr[start]);
        if(start > end)return null;
        int max = start;
        for(int i = start; i <= end; i++){
            if(arr[i] > arr[max])max = i;
        }
        TreeNode root = new TreeNode(arr[max]);
        root.left = construct(arr, start, max-1);
        root.right = construct(arr, max+1, end);
        return root;

    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }
}