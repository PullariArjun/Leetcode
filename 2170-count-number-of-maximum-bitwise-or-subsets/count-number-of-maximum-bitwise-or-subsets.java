class Solution {
    public int fun(int nums[], int ind, int or, int curr){
        if(ind < 0) return curr == or?1:0;
        return fun(nums, ind-1, or, curr|nums[ind]) + fun(nums, ind-1, or, curr);
    }
    public int countMaxOrSubsets(int[] nums) {
        int or = 0;
        for(int i: nums) or |= i;
        return fun(nums, nums.length-1, or, 0);
    }
}