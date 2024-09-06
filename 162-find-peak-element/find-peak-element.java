class Solution {
    public int fun(int[] arr, int start, int end){
        if(start > end)return -1;
        int mid = start + (end - start)/2;
        if(mid == 0 && arr[0] > arr[1])return mid;
        if(mid == arr.length-1 && arr[mid] > arr[mid-1])return mid;
        if(mid != 0 && mid != arr.length-1 && arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])return mid;
        int x = fun(arr, start, mid-1);
        int y = fun(arr, mid+1, end);
        if(x != -1)return x;
        return y;
    }
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1)return 0;
        
        return fun(nums, 0, nums.length-1);
    }
}