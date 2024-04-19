class Solution {
    public void fill(int i, int j, char[][] grid, boolean[][] arr){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)return;
        if(grid[i][j] == '0')return;
        if(arr[i][j])return;
        arr[i][j] = true;
        fill(i+1, j, grid, arr);
        fill(i, j+1, grid, arr);
        fill(i-1, j, grid, arr);
        fill(i, j-1, grid, arr);
    }
    public int fun(int n, int m, char grid[][], boolean[][] arr){
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !arr[i][j]){
                    ans++;
                    fill(i, j, grid, arr);
                }
            }
        }
        return ans;
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean arr[][] = new boolean[n][m];
        return fun(n, m, grid, arr);
    }
}