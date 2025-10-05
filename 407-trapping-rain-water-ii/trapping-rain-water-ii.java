class Pair{
    int row, col, height;
    Pair(){}
    Pair(int row, int col, int height){
        this.row = row;
        this.col = col;
        this.height = height;
    }
}
class Solution {
    public boolean isPossible(int row, int col, int n, int m){
        return row < n && row >= 0 && col < m && col >= 0;
    }
    public int trapRainWater(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.height - b.height);
        boolean vis[][] = new boolean[n][m];
        for(int i = 0; i < n; i++){
            pq.offer(new Pair(i, 0, mat[i][0]));
            pq.offer(new Pair(i, m-1, mat[i][m-1]));
            vis[i][0] = vis[i][m-1] = true;
        }
        for(int i = 0; i < m; i++){
            pq.offer(new Pair(0, i, mat[0][i]));
            pq.offer(new Pair(n-1, i, mat[n-1][i]));
            vis[0][i] = vis[n-1][i] = true;
        }
        int dir[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int ans = 0;
        while(!pq.isEmpty()){
            Pair poll = pq.poll();
            for(int[] d: dir){
                int nRow = poll.row + d[0];
                int nCol = poll.col + d[1];
                if(isPossible(nRow, nCol, n, m) && !vis[nRow][nCol]){
                    if(poll.height > mat[nRow][nCol]){
                        ans += poll.height - mat[nRow][nCol];
                        pq.offer(new Pair(nRow, nCol, poll.height));
                    } else {
                        pq.offer(new Pair(nRow, nCol, mat[nRow][nCol]));
                    }
                    vis[nRow][nCol] = true;
                }
            }
        }
        return ans;
    }
}