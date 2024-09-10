class Solution {
    boolean visited[];
    public boolean dfs(List<List<Integer>> graph, int start, boolean[] vis){
        if(vis[start])return true;
        visited[start] = true;
        boolean ans = false;
        for(int i: graph.get(start)){
            vis[start] = true;
            ans = ans || dfs(graph, i, vis);
            vis[start] = false;
        }
        return ans;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int indegree[] = new int[numCourses];
        // int n = prerequisites.length;
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int i[]: prerequisites){
            graph.get(i[0]).add(i[1]);
            indegree[i[1]]++;
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0)
                que.add(i);
        }
        while(!que.isEmpty()){
            int poll = que.poll();
            ans.add(poll);
            for(int i: graph.get(poll)){
                indegree[i]--;
                if(indegree[i] == 0)que.offer(i);
            }
        }
        return ans.size() == numCourses;

        
        
    }
}