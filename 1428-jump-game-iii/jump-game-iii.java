class Solution {

    public boolean fun(int[] arr, int start, boolean vis[]){
        if(start < 0 || start >= arr.length)return false;
        if(vis[start])return false;
        if(arr[start] == 0)return true; 

        vis[start] = true;

        boolean ans = fun(arr, start + arr[start], vis) || fun(arr, start - arr[start], vis);

        vis[start] = false;

        return ans;
    }
    public boolean canReach(int[] arr, int start) {
        return fun(arr, start, new boolean[arr.length]);
    }
}