class Solution {
    public int lowerBound(int arr[], int lower, int start){
        int ele = arr[start-1];
        int end = arr.length-1;
        int ans = -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(ele+arr[mid] >= lower){
                ans = mid;
                end = mid-1;
            }else
                start = mid+1;
        } 
        return ans;
        
    }
    public int upperBound(int arr[], int upper, int start){
        int ele = arr[start-1];
        int end = arr.length-1;
        int ans = -1;
        while(start <= end){
            int mid = (start+end)/2;
            if(ele+arr[mid] <= upper){
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }
    public long countFairPairs(int[] arr, int lower, int upper) {
        Arrays.sort(arr);
        long ans = 0;
        for(int i = 0; i < arr.length; i++){
            int lb = lowerBound(arr, lower, i+1);
            int ub = upperBound(arr, upper, i+1);
            if(ub >= lb && ub != -1 && lb != -1){
                ans += (long)(ub - lb + 1);
            }
        }
        return ans;
    }
}