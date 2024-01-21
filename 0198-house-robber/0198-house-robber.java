class Solution {
    public int fun(int arr[], int n, int[] dp, boolean calculated[]){
        if(n < 0)return 0;
        if(calculated[n])return dp[n];
        calculated[n] = true;
        return dp[n] = Math.max(arr[n] + fun(arr, n-2, dp, calculated), arr[n] + fun(arr, n-3, dp, calculated));
    }
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        boolean calculated[] = new boolean[nums.length];
        return Math.max(fun(nums, nums.length-1, dp, calculated), fun(nums, nums.length-2, dp, calculated));
    }
}