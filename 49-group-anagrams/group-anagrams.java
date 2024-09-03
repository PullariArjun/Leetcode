class Solution {

    public boolean isAnagrams(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        if(m != n)return false;
        int arr[] = new int[26];
        for(char c: s1.toCharArray())
            arr[c-'a']++;
        for(char c: s2.toCharArray())
            arr[c-'a']--;
        for(int i: arr){
            if(i != 0)return false;
        }
        return true;
        
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        boolean vis[] = new boolean[n];
        List<List<String>> ans= new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(vis[i])continue;
            List<String> lst = new ArrayList<>();
            lst.add(strs[i]);
            for(int j = i+1; j < n; j++){
                if(vis[j])continue;
                if(isAnagrams(strs[i], strs[j])){
                    lst.add(strs[j]);
                    vis[j] = true;
                }
            }
            ans.add(lst);
        }
        return ans;
    }
}