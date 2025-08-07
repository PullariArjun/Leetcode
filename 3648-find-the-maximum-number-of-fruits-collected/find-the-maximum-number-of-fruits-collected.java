class Solution {
    public int maxCollectedFruits(int[][] arr) {
        int ans = 0;
        int n = arr.length;
        for(int i = 0; i < arr.length; i++){
            ans += arr[i][i];
        }
        for(int j = n-2; j >= 0; j--)
            for(int i = n-1; i > j; i--){
                int max = 0;
                if(i-1 >= 0 && j+1 < n && i-1 > j+1)max = Math.max(max, arr[i-1][j+1]);
                if(j+1 < n && i > j+1)max = Math.max(max, arr[i][j+1]);
                if(i+1 < n && j+1 < n && i+1 > j+1)max = Math.max(max, arr[i+1][j+1]);
                arr[i][j] += max;
            }
        for(int i = n-2; i >= 0; i--){
            for(int j = n-1; j > i; j--){
                int max = 0;
                if(i+1 < n && j+1 < n && j+1 > i+1)max = Math.max(max, arr[i+1][j+1]);
                if(i+1 < n && j-1 >= 0 && j-1 > i+1)max = Math.max(max, arr[i+1][j-1]);
                if(i+1 < n && j > i+1)max = Math.max(max, arr[i+1][j]);
                arr[i][j] += max;
            }
        }
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < n; j++){
        //         System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return ans + arr[0][n-1] + arr[n-1][0];
    }
}