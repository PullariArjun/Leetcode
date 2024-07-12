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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);
        while(!que.isEmpty()){
            List<Integer> lst = new ArrayList<>();
            int n = que.size();
            while(n-->0){
                TreeNode node  = que.poll();
                if(node.left != null)que.offer(node.left);
                if(node.right != null)que.offer(node.right);
                lst.add(node.val);
            }
            ans.add(lst);
        }
        return ans;
    }
}