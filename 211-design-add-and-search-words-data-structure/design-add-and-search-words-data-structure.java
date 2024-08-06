class Node{
    Node arr[];
    boolean ends;
    Node(){
        arr = new Node[26];
        ends = false;
    }
}
class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node temp = root;
        for(char c: word.toCharArray()){
            if(temp.arr[c-'a'] == null)
                temp.arr[c-'a'] = new Node();
            temp = temp.arr[c-'a'];
        }
        temp.ends = true;
    }
    
    public boolean search(String word, int ind, int n, Node trie){
        if(ind >= n)return trie.ends;
        if(trie == null)return false;
        if(word.charAt(ind) != '.' && trie.arr[word.charAt(ind) - 'a'] == null)return false;
        if(word.charAt(ind) != '.'){
            return search(word, ind+1, n, trie.arr[word.charAt(ind) - 'a']);
        }else{
            boolean ans = false;
            for(int i = 0; i < 26; i++){
                if(trie.arr[i] != null){
                    ans = ans | search(word, ind+1, n, trie.arr[i]);
                }
            }
            return ans;
        }
    }
    public boolean search(String word) {
        Node temp = root;
        return search(word, 0, word.length(), temp);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */