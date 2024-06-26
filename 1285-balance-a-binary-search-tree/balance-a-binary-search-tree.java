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
    public TreeNode convertToTree(List<Integer> lst, int i, int j){
        if(i == j)return new TreeNode(lst.get(i));
        if(i > j)return null;

        int mid = (i+j)/2;
        TreeNode root = new TreeNode(lst.get(mid));
        root.left = convertToTree(lst, i, mid-1);
        root.right = convertToTree(lst, mid+1, j);
        return root;

    }
    public void convertToList(TreeNode root, List<Integer> lst){
        if(root == null)return;
        convertToList(root.left, lst);
        lst.add(root.val);
        convertToList(root.right, lst);

    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> lst= new ArrayList<>();
        convertToList(root, lst);
        return convertToTree(lst, 0, lst.size()-1);

    }
}