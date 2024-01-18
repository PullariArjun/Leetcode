class Solution {
    int dp[] = new int[46];
    int fun(int n){
        if(n == 0 || n == 1)return 1;
        if(dp[n] != 0)return dp[n];
        return dp[n] = fun(n-1)+fun(n-2);
    }
    public int climbStairs(int n) {
        return fun(n);
    }
}