/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)return root;
        if(root.left == null && root.right == null)return root;
        root.left.next = root.right;
        Node y = root.left;
        while(y != null){
            Node x = y;
            while(x != null){
                if(x.left == null)return root;
                x.left.next = x.right;
                if(x.next != null)
                x.right.next = x.next.left;
                x = x.next;
            }
            y = y.left;
        }
        return root;
    }
}