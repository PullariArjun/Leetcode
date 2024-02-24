class Solution {
    int fun(int arr[], int dp[], int index){
        if(index >= arr.length-1)return 0;
        if(dp[index] != 0)return dp[index];
        int min = arr.length+2;
        for(int i = 1; i <= arr[index]; i++){
            min = Math.min(min, 1+fun(arr, dp, index+i));
        }
        return dp[index] = min;
    }
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        return fun(nums, dp, 0);
    }
}