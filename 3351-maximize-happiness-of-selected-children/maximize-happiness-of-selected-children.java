class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int neg = 0, len = happiness.length;
        long ans = 0;
        for(int i = len-1; i >= Math.max(len-k, 0); i--){
            ans += (long)Math.max(happiness[i]-neg, 0);
            neg++;
        }
        return ans;
    }
}