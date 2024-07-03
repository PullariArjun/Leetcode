class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 4)return 0;
        Arrays.sort(nums);
        int min = nums[n-1]-nums[0];
        min = Math.min(nums[n-4]-nums[0], min);
        min = Math.min(nums[n-3]-nums[1], min);
        min = Math.min(nums[n-2]-nums[2], min);
        min = Math.min(nums[n-1]-nums[3], min);
        return min;
    }
}