class Solution {
    public int minLengthAfterRemovals(String s) {
        int ans = 0;
        for(char c: s.toCharArray()){
            if(c == 'a')ans++;
            else ans--;
        }
        return Math.abs(ans);
    }
}