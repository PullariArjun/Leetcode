class Solution {
    public void reverse(int[] arr, int i, int j){
        while(i < j){
            arr[i] += arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n-1;
        while(i > 0 && arr[i] <= arr[i-1])i--;
        if(i <= 0){
            reverse(arr,0,n-1);
            return;
        }
        int j= n-1;
        while(arr[j] <= arr[i-1])j--;
        arr[i-1] += arr[j];
        arr[j] = arr[i-1] - arr[j];
        arr[i-1] = arr[i-1] - arr[j];
        reverse(arr, i, n-1);
    }
}