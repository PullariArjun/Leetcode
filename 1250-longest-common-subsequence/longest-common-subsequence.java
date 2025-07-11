class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i = 0; i < n; i++)dp[i][m] = 0;
        for(int i = 0; i < m; i++)dp[n][i] = 0;
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(text1.charAt(i) == text2.charAt(j))dp[i][j] = 1 + dp[i+1][j+1];
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}