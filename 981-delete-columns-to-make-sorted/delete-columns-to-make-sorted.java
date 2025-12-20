class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length, m = strs[0].length();
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n-1; j++){
                if(strs[j].charAt(i) > strs[j+1].charAt(i)){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}