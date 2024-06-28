class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int arr[] = new int[n];
        for(int i[]: roads){
            arr[i[0]]++;
            arr[i[1]]++;
        }
        Arrays.sort(arr);
        int i = n-1;
        long ans = 0;
        for(;i >= 0; i--){
            ans += (long)arr[i]*(long)n;
            n--;
        }
        return ans;
    }
}