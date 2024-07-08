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
 class pair{
    TreeNode node;
    int lev;
    pair(){};
    pair(TreeNode node, int lev){
        this.node = node;
        this.lev = lev;
    }
 }
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        TreeNode startNode = root;

        if(root.val != start){
            while(!que.isEmpty()){
                
                TreeNode pop = que.poll();
                if(pop.left != null){
                    que.offer(pop.left);
                    map.put(pop.left, pop);
                    if(pop.left.val == start){
                        startNode = pop.left;
                        break;
                    }

                }
                if(pop.right != null){
                    que.offer(pop.right);
                    map.put(pop.right, pop);
                    if(pop.right.val == start){
                        startNode = pop.right;
                        break;
                    }
                }
            }
        }

        Queue<pair> queue = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        int ans = 0;
        set.add(startNode);
        queue.offer(new pair(startNode, 0));
        // System.out.println(queue);
        while(!queue.isEmpty()){
            pair pop = queue.poll();
            // if(pop.node != null)
            // System.out.println(pop.node.val+" "+pop.lev);
            if(map.containsKey(pop.node) && map.get(pop.node) != null){
                if(!set.contains(map.get(pop.node))){
                    set.add(map.get(pop.node));
                    queue.offer(new pair(map.get(pop.node), pop.lev+1));
                }
            }
            if(pop.node != null && pop.node.right != null){
                if(!set.contains(pop.node.right)){
                    set.add(pop.node.right);
                    queue.offer(new pair(pop.node.right, pop.lev+1));
                    // ans = Math.max()
                }
            }
            if(pop.node != null && pop.node.left != null){
                if(!set.contains(pop.node.left)){
                    set.add(pop.node.left);
                    queue.offer(new pair(pop.node.left, pop.lev+1));
                }
            }
            ans = Math.max(pop.lev, ans);

        }
        return ans;
    }
}