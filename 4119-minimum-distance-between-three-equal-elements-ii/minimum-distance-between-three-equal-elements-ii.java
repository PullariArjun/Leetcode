class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int inds[] = new int[100001];
        int nextind[] = new int[n];
        Arrays.fill(nextind, -1);
        Arrays.fill(inds, -1);
        for(int i = n-1; i>= 0; i--){
            nextind[i] = inds[nums[i]];
            inds[nums[i]] = i;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(nextind[i] != -1 && nextind[nextind[i]] != -1){
                int dist = Math.abs(i - nextind[i]) + Math.abs(nextind[i] - nextind[nextind[i]]) + Math.abs(i - nextind[nextind[i]]);
                min = Math.min(min, dist);
            }
        }
        return min == Integer.MAX_VALUE?-1:min;
    }
}