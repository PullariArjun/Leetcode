class Solution {
    public int isPossible(int arr[], int n, int max){
        int x = 0, i = 0;
        for(i = 0; i < arr.length; i++){
            x += arr[i]/max;
            if(arr[i]%max != 0)x++;
        }
        return x;
    }
    public int minimizedMaximum(int n, int[] arr) {
        Arrays.sort(arr);
        int start = 1, end = arr[arr.length-1];
        int ans = -1;
        while(start <= end){
            int mid = (start + end)/2;
            int pos = isPossible(arr, n, mid);
            if(pos <= n){
                ans = mid;
                end = mid-1;
            }else start = mid+1;
        }
        return ans;
    }
}