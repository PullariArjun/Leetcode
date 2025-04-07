class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(grid[i][j] == 2)que.offer(new int[]{i, j, 0});
        int trav[][] = {
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
        };
        int ans = 0;
        while(!que.isEmpty()){
            int arr[] = que.poll();
            ans = Math.max(ans, arr[2]);
            for(int[] tr: trav){
                int x = arr[0] + tr[0];
                int y = arr[1] + tr[1];
                int time = arr[2];
                if(x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1){
                    que.offer(new int[]{x, y, time+1});
                    grid[x][y] = 2;
                }

            }
        }
        int flag = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(grid[i][j] == 1)flag++;
        return flag > 0?-1:ans;
    }
}