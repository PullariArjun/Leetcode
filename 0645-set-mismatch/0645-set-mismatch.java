class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length+2;
        int arr[] = new int[n];
        int ans[] = new int[2];
        for(int i: nums)arr[i]++;
        for(int i = 1; i < n; i++){
            if(arr[i] == 0 && ans[1] == 0)ans[1] = i;
            if(arr[i] == 2 && ans[0] == 0)ans[0] = i;
        }
        return ans;
    }
}