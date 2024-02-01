class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        if(n%3 != 0)return new int[0][0];
        Arrays.sort(nums);
        int i = 0, r = 0;
        int arr[][] = new int[n/3][3];
        while(i < n){
            if(nums[i+2] - nums[i] > k || nums[i+2] - nums[i+1] > k || nums[i+1] - nums[i] > k)return new int[0][0];
            arr[r][0] = nums[i];
            arr[r][1] = nums[i+1];
            arr[r][2] = nums[i+2];
            r++;
            i+=3;
        }
        return arr;
        
    }
}