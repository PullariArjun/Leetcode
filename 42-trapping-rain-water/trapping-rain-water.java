class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int l[] = new int[n];
        int r[] = new int[n];
        int maxl = arr[0], maxr = arr[n-1];
        for(int i = 0; i < n; i++){
            maxl = Math.max(maxl, arr[i]);
            l[i] = maxl;
            maxr = Math.max(maxr, arr[n-1-i]);
            r[n-1-i] = maxr;
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = ans + Math.min(l[i], r[i]) - arr[i];
        }
        return ans;

    }
}