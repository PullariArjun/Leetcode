class Solution {
    public int fun(int n, int trav, int prev){
        if(n == trav)return 0;
        if(trav > n)return n;
        return Math.min(1+fun(n, trav+prev, prev), 2+fun(n, trav*2, trav));
    }
    public int minSteps(int n) {
        if(n == 1)return 0;
        return 1+fun(n, 1, 1);
    }
}