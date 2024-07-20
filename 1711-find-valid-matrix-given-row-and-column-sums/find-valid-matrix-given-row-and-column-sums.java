class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int i = 0, j = 0;
        int n = rowSum.length;
        int m = colSum.length;
        int arr[][] = new int[n][m];
        while(i < n && j < m){
            if(rowSum[i] < colSum[j]){
                arr[i][j] = rowSum[i];
                colSum[j] -= rowSum[i];
                rowSum[i] = 0;
                i++;
            }else{
                arr[i][j] = colSum[j];
                rowSum[i] -= colSum[j];
                colSum[j] = 0;
                j++;
            }
        }
        return arr;
    }
}