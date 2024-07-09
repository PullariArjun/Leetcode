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
    List<TreeNode> lst = new ArrayList<>();
    public void inOrder(TreeNode root){
        if(root == null)return;
        inOrder(root.left);
        lst.add(root);
        inOrder(root.right);
    }
    public void recoverTree(TreeNode root) {
        inOrder(root);
        ArrayList<Integer> arr = new ArrayList<>();
        int n = lst.size();
        for(int i = 1; i < n; i++){
            if(lst.get(i).val < lst.get(i-1).val)arr.add(i);
        }


        if(arr.size() ==1)arr.add(arr.get(0) - 1);
        else arr.set(0, arr.get(0)-1);

        
        lst.get(arr.get(0)).val += lst.get(arr.get(1)).val;
        lst.get(arr.get(1)).val = lst.get(arr.get(0)).val - lst.get(arr.get(1)).val;
        lst.get(arr.get(0)).val -= lst.get(arr.get(1)).val;
    }
}