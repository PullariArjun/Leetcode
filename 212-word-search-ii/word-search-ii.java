class Node{
    Node arr[];
    boolean ends;
    Node(){
        this.arr = new Node[26];
        this.ends = false;
    }
}
class Solution {

    Set<String> ans;
    boolean vis[][];
    StringBuilder sb;
    int length;
    public void fun(Node trie, char board[][], int row, int col){
        int n = board.length;
        int m = board[0].length;

        if(trie.ends == true){
            ans.add(sb.toString());
        }
        if(row < 0 || col < 0 || row >= n || col >= m)return;
        if(vis[row][col])return;
        if(trie.arr[board[row][col]-'a'] == null)return;
        
        vis[row][col] = true;
        sb.append(board[row][col]);
        length++;
        fun(trie.arr[board[row][col]-'a'], board, row+1, col);
        fun(trie.arr[board[row][col]-'a'], board, row, col+1);
        fun(trie.arr[board[row][col]-'a'], board, row, col-1);
        fun(trie.arr[board[row][col]-'a'], board, row-1, col);
        sb.deleteCharAt(length--);
        vis[row][col] = false;


    }

    public List<String> findWords(char[][] board, String[] words) {
        Node trie = new Node();
        for(String s: words){
            Node temp = trie;
            for(char c: s.toCharArray()){
                if(temp.arr[c-'a'] == null)temp.arr[c-'a'] = new Node();
                temp = temp.arr[c-'a'];
            }
            temp.ends = true;
        }

        int n = board.length;
        int m = board[0].length;

        vis = new boolean[n][m];
        sb = new StringBuilder();
        ans = new HashSet<String>();
        length = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(trie.arr[board[i][j]-'a'] != null){
                    fun(trie, board, i, j);
                }
            }
        }
        return new ArrayList<>(ans);

    }
}