class Solution {
    public int largestCombination(int[] candidates) {
        int n = candidates.length;
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int x = 0;
            for(int j = 0; j < n; j++)
                x += (candidates[j] & (1 << i)) != 0?1:0;
            ans = Math.max(ans, x);
        }
        return ans;
    }
}