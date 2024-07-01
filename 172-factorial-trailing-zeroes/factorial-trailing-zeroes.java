class Solution {
    int count5s(int n){
        int ans = 0;
        while(n > 0){
            if(n%5 == 0){
                n = n/5;
                ans++;
            }else break;
        }
        return ans;
    }
    public int trailingZeroes(int n) {
        int ans = 0;
        for(int i = 1; i <= n; i++){
            ans += count5s(i);
        }
        return ans;
    }
}