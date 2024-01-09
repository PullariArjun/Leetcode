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
    void fun(TreeNode root, ArrayList<Integer> al){
        if(root == null)return;
        if(root.left == null && root.right == null){
            al.add(root.val);
            return;
        }
        fun(root.left, al);
        fun(root.right, al);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        fun(root1, al1);
        fun(root2, al2);
        int n = al1.size();
        int m = al2.size();
        if(m != n)return false;
        for(int i= 0; i < n; i++){
            if(al1.get(i) != al2.get(i))return false;
        }
        return true;
    }
}