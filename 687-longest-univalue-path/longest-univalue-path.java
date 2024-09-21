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
    public void buildMap(TreeNode root, Map<TreeNode, TreeNode> map){
        if(root == null)return;
        if(root.left != null)map.put(root.left, root);
        if(root.right != null)map.put(root.right, root);
        buildMap(root.left, map);
        buildMap(root.right, map);
    }

    public int calHeight(TreeNode root, Map<TreeNode, TreeNode> map, TreeNode src, TreeNode prev){
        if(root == null)return 0;
        if(root.val != src.val)return 0;
        int x = 0, y = 0, z = 0;
        if(root.left != prev)x = calHeight(root.left, map, src, root);
        if(root.right != prev)y = calHeight(root.right, map, src, root);
        if(map.get(root) != prev)z = calHeight(map.get(root), map, src, root);
        return 1+Math.max(x, Math.max(y, z));
    }
    int ans = 0;
    public void fun(TreeNode root, Map<TreeNode, TreeNode> map){
        if(root == null)return;

        ans = Math.max(ans,calHeight(root, map, root, root));

        fun(root.left, map);
        fun(root.right, map);
        
    }
    public int longestUnivaluePath(TreeNode root) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        if(root == null)return 0;
        map.put(root, null);
        buildMap(root, map);
        fun(root, map);
        return ans-1;
    }
}