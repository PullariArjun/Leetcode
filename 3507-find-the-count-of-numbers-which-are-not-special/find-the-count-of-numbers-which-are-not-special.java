class Solution {
    boolean f(int n){
        if(n < 2)return false;
        for(int i = 2; i*i <= n; i++){
            if(n%i == 0)return false;
        }
        return true;
    }
    public int nonSpecialCount(int l, int r) {
        int x = (int)Math.sqrt(l);
        if(x*x != l)x++;
        int y = (int)Math.sqrt(r);
        int a = 0;
        for(int i = x; i <= y; i++){
            if(f(i))a++;
        }
        return r+1-l-a;
    }
}