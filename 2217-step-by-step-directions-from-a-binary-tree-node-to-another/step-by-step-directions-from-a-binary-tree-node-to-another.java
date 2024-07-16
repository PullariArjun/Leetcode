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
    String ans;
    StringBuilder sb;
    int length = -1;
    TreeNode startNode;
    public int buildMap(TreeNode root, HashMap<TreeNode, TreeNode> map, int startVal){
        if(root == null)return 0;
        if(root.val == startVal)startNode = root;
        if(root.left != null)map.put(root.left, root);
        if(root.right != null)map.put(root.right, root);
        return 1 + buildMap(root.left, map, startVal) + buildMap(root.right, map, startVal);
    }

    public void findPath(TreeNode startNode, int destVal, HashMap<TreeNode, TreeNode> map, boolean vis[]){
        if(startNode == null)return;
        if(startNode.val == destVal){
            ans = sb.toString();
            return;
        }
        if(vis[startNode.val])return;
        vis[startNode.val] = true;

        if(map.get(startNode) != null){
            sb.append('U');
            length++;
            findPath(map.get(startNode), destVal, map, vis);
            sb.deleteCharAt(length--);
        }
        if(startNode.left != null){
            sb.append('L');
            length++;
            findPath(startNode.left, destVal, map, vis);
            sb.deleteCharAt(length--);
        }
        if(startNode.right != null){
            sb.append('R');
            length++;
            findPath(startNode.right, destVal, map, vis);
            sb.deleteCharAt(length--);
        }
        vis[startNode.val] = false;
        


    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        int n = buildMap(root, map, startValue);
        boolean vis[] = new boolean[n+1];
        sb = new StringBuilder();
        findPath(startNode, destValue, map, vis);
        return ans;
    }
}