class Node{
    Node arr[];
    boolean ends;
    Node(){
        arr = new Node[26];
        ends = false;
    }
}
class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        for(char c: word.toCharArray()){
            if(temp.arr[c-'a'] == null)temp.arr[c-'a'] = new Node();
            temp = temp.arr[c-'a'];
        }
        temp.ends = true;
    }
    
    public boolean search(String word) {
        Node temp = root;
        for(char c: word.toCharArray()){
            if(temp.arr[c-'a'] == null)return false;
            temp = temp.arr[c-'a'];
        }
        return temp.ends;
    }
    
    public boolean startsWith(String word) {
        Node temp = root;
        for(char c: word.toCharArray()){
            if(temp.arr[c-'a'] == null)return false;
            temp = temp.arr[c-'a'];
        }
        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */