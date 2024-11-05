class Solution {
    public int longestOnes(int[] arr, int k) {
        int ans = 0;
        int i = 0, j = 0, zc = 0;
        while(j < arr.length){
            if(zc > k){
                if(arr[i] == 0)zc--;
                i++;
            }else{
                ans = Math.max(j -i , ans);
                if(arr[j] == 0)zc++;
                j++;
            }
        }
        if(zc <= k)ans = Math.max(j - i, ans);
        return ans;
        
    }
}