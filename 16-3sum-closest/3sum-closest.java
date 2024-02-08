class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        int temp = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int arr[] = new int[3];
        for(int k = 0; k < nums.length - 1; k++){
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int x = nums[i] + nums[j] + nums[k];
                if(Math.abs(x - target) < temp){
                    ans = x;
                    temp = Math.abs(x - target);
                    arr[0] = nums[k];
                    arr[1] = nums[i];
                    arr[2] = nums[j];
                }
                if(x >= target)
                    j--;
                else
                    i++;
            }
        }
        // System.out.println(Arrays.toString(arr));
        return ans;
    }
}