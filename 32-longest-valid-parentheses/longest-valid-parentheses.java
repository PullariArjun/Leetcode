class Solution {
    public int longestValidParentheses(String s) {
        int x = 0, y = 0, ans = 0, n = s.length();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '(')x++;
            else y++;
            if(x == y)ans = Math.max(ans, y*2);
            else if(x < y){
                x = 0;
                y = 0;
            }
        }
        x = 0;
        y = 0;
        for(int i = n-1; i >= 0; i--){
            if(s.charAt(i) == '(')x++;
            else y++;
            if(x == y) ans= Math.max(ans, y*2);
            else if(x > y){
                x = 0;
                y = 0;
            }
        }
        return ans;
    }
}