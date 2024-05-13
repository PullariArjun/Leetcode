class Solution {
    int fun(int[][] arr, int i, int j, int dp[][]){
        int n = arr.length;
        int m = arr[0].length;
        // if(i < 0 || i >= n || j < 0 || j >= m)return 0;
        if(dp[i][j] != 0)return dp[i][j];
        int a = 0, b = 0, c = 0, d = 0;
        if(i+1 < n && arr[i+1][j] > arr[i][j])a = fun(arr, i+1, j, dp);
        if(i-1 >= 0 && arr[i-1][j] > arr[i][j])b = fun(arr, i-1, j, dp);
        if(j+1 < m && arr[i][j+1] > arr[i][j])c = fun(arr, i, j+1, dp);
        if(j-1 >= 0 && arr[i][j-1] > arr[i][j])d = fun(arr, i, j-1, dp);
        return dp[i][j] = 1+Math.max(Math.max(a,b), Math.max(c, d));

    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dp[i][j] == 0){
                    max = Math.max(max, fun(matrix, i, j, dp));
                }
            }
        }
        return max;
    }
}