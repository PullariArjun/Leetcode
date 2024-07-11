class Solution {
    public int fun(List<List<Integer>> arr, int i, int j, int depth, int dp[][], boolean vis[][]){
        if(i >= depth)return 0;
        if(vis[i][j])return dp[i][j];
        vis[i][j] = true;
        return dp[i][j] = arr.get(i).get(j) + Math.min(fun(arr, i+1, j, depth, dp, vis), fun(arr, i+1, j+1, depth, dp, vis));
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        boolean vis[][] = new boolean[n][n];
        return fun(triangle, 0, 0, n, dp, vis);
    }
}