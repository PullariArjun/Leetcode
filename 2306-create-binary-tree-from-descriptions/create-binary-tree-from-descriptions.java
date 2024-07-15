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
    void link(TreeNode node1, TreeNode node2, int a){
        if(a == 0)node1.right = node2;
        else node1.left = node2;
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for(int i[] : descriptions){
            boolean n1 = map.containsKey(i[0]);
            boolean n2 = map.containsKey(i[1]);
            if(n1 && n2){
                link(map.get(i[0]), map.get(i[1]), i[2]);
            }
            else if(n1){
                TreeNode node = new TreeNode(i[1]);
                map.put(i[1], node);
                link(map.get(i[0]), node, i[2]);
            }
            else if(n2){
                TreeNode node = new TreeNode(i[0]);
                map.put(i[0], node);
                link(node, map.get(i[1]), i[2]);
            }
            else{
                TreeNode node1 = new TreeNode(i[0]);
                TreeNode node2 = new TreeNode(i[1]);
                map.put(i[0], node1);
                map.put(i[1], node2);
                link(node1, node2, i[2]);
            }
        }
        for(int i[]: descriptions){
            map.put(i[1], null);
        }
        for(int key: map.keySet()){
            if(map.get(key) != null)return map.get(key);
        }
        return null;

    }
}