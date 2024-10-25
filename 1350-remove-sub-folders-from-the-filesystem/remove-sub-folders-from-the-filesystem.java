class Solution {
    class Node{
        Node arr[];
        boolean ends;
        Node(){
            arr = new Node[27];
            ends = false;
        }
    }

    public boolean isValid(String s, Node trie){
        Node temp = trie;
        int len = s.length();
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '/'){
                if(temp.arr[26] == null)temp.arr[26] = new Node();
                if(temp.ends)return false;
                temp = temp.arr[26];
            }else{
                if(temp.arr[s.charAt(i)-'a'] == null)temp.arr[s.charAt(i) - 'a'] = new Node();
                temp = temp.arr[s.charAt(i)-'a'];
            }
        }
        temp.ends = true;
        return true;
    }
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        System.out.println(Arrays.toString(folder));
        Node trie = new Node();
        List<String> ans = new ArrayList<>();
        for(String s: folder){
            if(isValid(s, trie))ans.add(s);
        }
        return ans;
    }
}