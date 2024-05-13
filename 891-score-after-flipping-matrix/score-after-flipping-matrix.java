class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 0){
                for(int j = 0; j < m; j++){
                    grid[i][j] ^= 1;
                }
            }
        }
        for(int i = 0; i < m; i++){
            int zc = 0, oc = 0;
            for(int j = 0; j < n; j++){
                if(grid[j][i] == 1)oc++;
                else zc++;
            }
            if(zc > oc){
                for(int j = 0; j < n; j++){
                    grid[j][i] ^= 1;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            int temp = 0;
            for(int j = m-1; j >= 0; j--){
                if(grid[i][j] == 1)
                    temp = temp | (1 << (m-1-j));
            }
            ans += temp;
        }
        return ans;
    }
}