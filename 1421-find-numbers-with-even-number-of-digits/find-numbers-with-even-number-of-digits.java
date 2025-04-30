class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int i: nums){
            if((int)Math.log10(i)%2 == 1)ans++;
        }
        return ans;
    }
}