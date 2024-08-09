class Solution {
    public boolean isMagic(int[][] arr, int i, int j, boolean map[]){
        if(i-1 < 0 || i+1 >= arr.length || j-1 < 0 || j+1 >= arr[0].length)return false;

        int sum = arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1];
        for(int x = i-1; x <= i+1; x++){
            int a = 0;
            for(int y = j-1; y <= j+1; y++){
                if(arr[x][y] < 1 || arr[x][y] > 9)return false;
                if(map[arr[x][y]])return false;
                map[arr[x][y]] = true;
                a += arr[x][y];
            }
            // System.out.print(a+" ");
            if(a != sum)return false;
        }
        for(int y = j-1; y <= j+1; y++){
            int a = 0;
            for(int x = i-1; x <= i+1; x++){
                a += arr[x][y];
            }
            // System.out.print(a+" ");
            if(a != sum)return false;
        }
        if(sum != arr[i-1][j-1]+arr[i][j]+arr[i+1][j+1])return false;
        if(sum != arr[i-1][j+1]+arr[i][j]+arr[i+1][j-1])return false;
        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        boolean map[] = new boolean[10];
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                Arrays.fill(map, false);
                if(isMagic(grid, i, j, map))ans++;
            }
        }
        return ans;
    }
}