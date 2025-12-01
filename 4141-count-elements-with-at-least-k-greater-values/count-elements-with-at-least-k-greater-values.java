class Solution {
    public int countElements(int[] nums, int k) {
        if(k == 0)return nums.length;
        int n = nums.length;
        Arrays.sort(nums);
        int i = n-k-1;
        for(i = n-k-1; i >= 0 && nums[i] == nums[n-k]; i--);
        return i+1;
    }
}