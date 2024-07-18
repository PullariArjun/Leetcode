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
    int ans = 0;
    Map<TreeNode, TreeNode> map;
    Map<TreeNode, Boolean> vis;
    public void buildMap(TreeNode root){
        if(root == null)return;
        if(root.left != null)map.put(root.left, root);
        if(root.right != null)map.put(root.right, root);
        vis.put(root, false);
        buildMap(root.left);
        buildMap(root.right);
    }
    public void fun(TreeNode root, int distance, TreeNode src){
        if(vis.get(root))return;
        if(distance < 0)return;
        if(distance >= -1 && src != root && root.left == null && root.right == null){
            // System.out.print(root.val+", ");
            ans++;
            return;
        }
        vis.put(root, true);
        if(root.left != null)
            fun(root.left, distance-1, src);
        if(root.right != null)
            fun(root.right, distance-1, src);
        if(map.get(root) != null)
            fun(map.get(root), distance-1, src);
        vis.put(root, false);
    }
    public void countGood(TreeNode root, int distance){
        if(root == null)return;
        if(root.left == null && root.right == null){
            // System.out.print(root.val+" -> ");
            fun(root, distance, root);
            // System.out.println();
            return;
        }
        countGood(root.left, distance);
        countGood(root.right, distance);        
    }
    public int countPairs(TreeNode root, int distance) {
        map = new HashMap<>();
        vis = new HashMap<>();
        ans = 0;
        map.put(root, null);
        buildMap(root);
        countGood(root, distance);
        return ans/2;

    }
}