class Solution {
    boolean visited[], dp[];
    
    public boolean fun(int[] nums, int n, int k){
        if(k >= n-1)return true;
        if(visited[k])return dp[k];
        boolean ans = false;
        for(int i = nums[k]; i > 0; i--){
            ans = ans || fun(nums, n, k+i);
        }
        visited[k] = true;
        return dp[k] = ans;
    }
    public boolean canJump(int[] nums) {
        if(nums.length == 1)return true;
        if(nums[0] == 0)return false;
        int n = nums.length;
        visited = new boolean[n+1];
        dp = new boolean[n+1];
        return fun(nums, nums.length, 0);
    }
}