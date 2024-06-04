class Solution {
    int dp[];
    public int fun(char[] arr, int ind){
        if(ind >= arr.length)return 1;
        if(arr[ind] == '0')return 0;
        if(dp[ind] != 0)return dp[ind];
        int left = 0, right = 0;
        if(ind < arr.length-1 && ((arr[ind]-'0')*10+(arr[ind+1]-'0')) <= 26)left = fun(arr, ind+2);
        right = fun(arr, ind+1);
        return dp[ind] = left+right;
    }
    public int numDecodings(String s) {
        char arr[] = s.toCharArray();
        if(arr[0] == '0')return 0;
        for(int i = 0; i < arr.length-1; i++)
            if(arr[i] == '0' && arr[i+1] == '0')return 0;
        dp = new int[arr.length];

        return fun(arr, 0);
    }
}