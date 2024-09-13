class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        for(int i = 1; i < arr.length; i++){
            arr[i] ^= arr[i-1];
        }
        int m = queries.length;
        int ans[] = new int[m];
        for(int i = 0; i < m; i++){
           if(queries[i][0] == 0)ans[i] = arr[queries[i][1]];
           else ans[i] = arr[queries[i][1]] ^ arr[queries[i][0]-1];
        }
        // System.out.println(Arrays.toString(arr));
        return ans;
    }
}