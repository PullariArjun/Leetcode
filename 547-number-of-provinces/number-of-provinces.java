class Solution {
    public void fun(ArrayList<Integer> graph[], boolean visited[], int ind){
        int n = graph[ind].size();
        for(int i = 0; i < n; i++){
            if(visited[graph[ind].get(i)])continue;
            visited[graph[ind].get(i)] = true;
            fun(graph, visited, graph[ind].get(i));
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i = 0; i < n; i++)graph[i] = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1 && i != j)graph[i].add(j);
            }
        }
        // for(List<Integer> i: arr)System.out.println(i);
        int ans = 0;
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                ans++;
                fun(graph, visited, i);
            }
        }
        return ans;
    }
}