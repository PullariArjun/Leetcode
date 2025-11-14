class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int arr[][] = new int[n+1][n+1];
        for(int q[]: queries){
            int row1 = q[0];
            int col1 = q[1];
            int row2 = q[2];
            int col2 = q[3];
            for(int i = row1; i <= row2; i++){
                arr[i][col1]++;
                arr[i][col2+1]--;
            }
        }
        int x = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                x += arr[i][j];
                arr[i][j] = x;
            }
        }
        int ans[][] = new int[n][n];
        for(int i = 0; i < n; i++) for (int j = 0; j < n; j++) ans[i][j] = arr[i][j];
        return ans;
    }
}