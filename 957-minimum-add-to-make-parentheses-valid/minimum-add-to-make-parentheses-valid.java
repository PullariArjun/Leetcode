class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0, cnt = 0;
        for(char c: s.toCharArray()){
            if(c == ')'){
                if(cnt == 0)ans++;
                else cnt--;
            } else cnt++;
        }
            return ans+cnt;
    }
}