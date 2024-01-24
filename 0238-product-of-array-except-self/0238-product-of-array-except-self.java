class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int zcnt = 0, pro = 1;
        for(int i:nums){
            if(i == 0){
                if(zcnt == 1)return new int[n];
                zcnt++;
            }
            else pro *= i;
        }
        if(zcnt == 1){
            for(int i = 0; i < n; i++){
                if(nums[i] == 0)
                    nums[i] = pro;
                else nums[i] = 0;
            }
            return nums;
        }
        for(int i = 0; i < n; i++)nums[i] = pro/nums[i];
        return nums;

        
    }
}