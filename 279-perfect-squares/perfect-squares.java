class Solution {
    public int numSquares(int n) {
        if(n < 4)return n;
        if(n == 4)return 1;
        int dp[] = new int[n+1];
        dp[1] = 1;
       
        for(int i = 1; i*i <= n; i++){
            dp[i*i] = 1;
        }
        for(int i = 2; i <= n; i++){
            if(dp[i] == 1)continue;
            // int x = (int)Math.sqrt(i);
            int min = Integer.MAX_VALUE;
            for(int j = 1; j*j <= i; j++){
                min = Math.min(min,  dp[i - j * j ]);
            }
            dp[i] = min+1;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
        //8 14 15 19 
    }
}