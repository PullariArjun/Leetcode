class Solution {
    boolean[][] visited;
    StringBuilder sb;
    int sbl = -1;
    public boolean fun(char[][] arr, String word, int len, int pos, int x, int y){
        int n = arr.length;
        int m = arr[0].length;

        if(pos+1 >= len && word.charAt(pos) == arr[x][y]){
            // System.out.print(sb+" ");
            return true;
        }

        if(word.charAt(pos) != arr[x][y]){
            // System.out.print(sb+" ");
            return false;
        }

        
        visited[x][y] = true;
        boolean a = false, b = false, c = false, d = false;
        
        if(x+1 < n && !visited[x+1][y]){
            sb.append(arr[x][y]);
            sbl++;
            a = fun(arr, word, len, pos+1, x+1, y);
            sb.deleteCharAt(sbl);
            sbl--;
        }


        if(y+1 < m && !visited[x][y+1]){
            sb.append(arr[x][y]);
            sbl++;
            b = fun(arr, word, len, pos+1, x, y+1);
            sb.deleteCharAt(sbl);
            sbl--;
        }


        if(x-1 >= 0 && !visited[x-1][y]){
            sb.append(arr[x][y]);
            sbl++;
            c = fun(arr, word, len, pos+1, x-1, y);
            sb.deleteCharAt(sbl);
            sbl--;
        }


        if(y-1 >= 0 && !visited[x][y-1]){
            sb.append(arr[x][y]);
            sbl++;
            d = fun(arr, word, len, pos+1, x, y-1);
            sb.deleteCharAt(sbl);
            sbl--;
        }


        visited[x][y] = false;
        return a || b || c || d;
        

    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int len = word.length();
        sb = new StringBuilder();
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // System.out.print(board[i][j]+",");
                if(board[i][j] == word.charAt(0) && fun(board, word, len, 0, i, j))
                    return true;
            }
        }
        System.out.print(1);
        return false;
    }
}