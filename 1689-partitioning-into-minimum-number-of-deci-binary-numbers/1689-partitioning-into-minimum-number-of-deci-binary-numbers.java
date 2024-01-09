class Solution {
    public int minPartitions(String s) {
        int n = s.length(), ans = 1;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans,s.charAt(i)-'0');
            if(ans == 9)return ans;
        }
        return ans;
    }
}