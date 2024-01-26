class Solution {
    int mod = (int)(1e9+7);
    int dp[][][];
    boolean visit[][][];
    public int fun(int m, int n, int mvs, int i, int j){
        if(i < 0 || i >= m || j < 0 || j >= n)return 1;
        if(mvs == 0)return 0;
        if(visit[i][j][mvs])return dp[i][j][mvs];
        int a = fun(m, n, mvs-1, i+1, j);
        int b = fun(m, n, mvs-1, i-1, j);
        int c = fun(m, n, mvs-1, i, j+1);
        int d = fun(m, n, mvs-1, i, j-1);
        int x = ((a%mod) + (b%mod))%mod;
        int y = ((c%mod) + (d%mod))%mod;
        visit[i][j][mvs] = true;
        return dp[i][j][mvs] = ((x%mod) + (y%mod))%mod;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn){
        dp = new int[m+1][n+1][maxMove+1];
        visit = new boolean[m+1][n+1][maxMove+1];
        return fun(m, n, maxMove, startRow, startColumn);
    }
}