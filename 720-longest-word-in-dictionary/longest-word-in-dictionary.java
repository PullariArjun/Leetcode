class Node{
    Node arr[];
    boolean ends;
    Node(){
        arr = new Node[26];
        ends = false;
    }
}
class Solution {
    
    public void addWord(String s, Node root){
        for(char c: s.toCharArray()){
            if(root.arr[c-'a'] == null)root.arr[c-'a'] = new Node();
            root = root.arr[c-'a'];
        }
        root.ends = true;
    }

    public boolean search(String s, Node root){
        for(char c: s.toCharArray()){
            if(root == null || root.arr[c-'a'] == null)return false;
            root = root.arr[c-'a'];
            if(!root.ends)return false;
        }
        return true;
    }
    public String compare(String s1, String s2){
        int n = s1.length();
        for(int i = 0; i < n; i++){
            if(s1.charAt(i) < s2.charAt(i))return s1;
            if(s1.charAt(i) > s2.charAt(i))return s2;
        }
        return s1;
    }
    public String longestWord(String[] words) {
        Node root = new Node();
        for(String s: words){
            Node temp = root;
            addWord(s, temp);
        }
        String ans = "";
        for(String s: words){
            Node temp = root;
            if(search(s, temp)){
                if(ans.length() < s.length())ans = s;
                if(ans.length() == s.length())ans = compare(ans, s);
            }
        }
        return ans;
    }
}