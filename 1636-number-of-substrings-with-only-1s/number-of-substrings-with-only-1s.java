class Solution {
    public int numSub(String s) {
        int ans = 0, mod = (int)(1e9+7);
        int x = 1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                ans = (ans + x)%mod;
                x++;
            } else x = 1;
        }
        return ans;
    }
}