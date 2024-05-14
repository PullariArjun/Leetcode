class Solution {
    boolean visited[][];
    public int fun(int[][] arr, int i, int j){
        int n = arr.length, m = arr[0].length;
        if(i < 0 || i >= n || j < 0 || j >= m)return 0;
        if(arr[i][j] == 0)return 0;
        if(visited[i][j])return 0;
        visited[i][j] = true;
        int left = fun(arr, i, j-1);
        int right = fun(arr, i, j+1);
        int top = fun(arr, i-1, j);
        int bottom = fun(arr, i+1, j);
        visited[i][j] = false;
        return arr[i][j] + Math.max(Math.max(top, bottom), Math.max(left, right));
    }
    public int getMaximumGold(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        visited = new boolean[n][m];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                max = Math.max(max, fun(grid, i, j));
            }
        }
        return max;
    }
}