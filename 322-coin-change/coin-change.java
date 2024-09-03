class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)return 0;
        int dp[] = new int[amount+1];
        int IM = Integer.MAX_VALUE;
        Arrays.fill(dp, IM);
        for(int i = 1; i <= amount; i++){
            for(int x : coins){
                if(x == i){
                    dp[i] = 1;
                    break;
                }
                if(x < i && dp[i-x] != IM){
                    dp[i] = Math.min(dp[i], 1+dp[i-x]);
                }
            }
        }
        if(dp[amount] == IM)return -1;
        return dp[amount];
    }
}