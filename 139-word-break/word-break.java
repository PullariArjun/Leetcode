class Solution {
    boolean x = false;
    public boolean fun(String s, Set<String> set, int start, int n, int dp[]){
        if(start >= n){
            x = true;
            return true;
        }
        if(dp[start] != 0)return dp[start] == 1;
        boolean ans = false;
        for(int i = start; i <= n; i++){
            if(!x && set.contains(s.substring(start, i)))
                ans = ans | fun(s, set, i, n, dp);
        }
        if(ans){
            dp[start] = 1;
        }else dp[start] = 2;
        return ans;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String str: wordDict){
            set.add(str);
        }
        return fun(s, set, 0, s.length(), new int[s.length()]);
    }
}