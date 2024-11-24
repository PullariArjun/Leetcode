class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                min = Math.min(min, Math.abs(matrix[i][j]));
                cnt += matrix[i][j] < 0? 1: 0;
                sum += (long)Math.abs(matrix[i][j]);
            }
        }
        return cnt%2 == 0?sum:sum-2*min;
    }
}