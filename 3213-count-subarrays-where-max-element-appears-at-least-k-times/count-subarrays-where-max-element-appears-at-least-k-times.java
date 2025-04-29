class Solution {
    public long countSubarrays(int[] arr, int k) {
        int max = arr[0], n = arr.length;
        for(int x: arr)max = Math.max(x, max);
        int j = 0;
        int x = 0;
        long ans = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == max)x++;
            while(x >= k){
                if(arr[j] == max)x--;
                j++;
            }
            ans += j;
        }
        return ans;
    }
}