class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> arr, int k) {
        int i = 1;
        // List<Integer> lst = new ArrayList<>()
        int n = arr.size();
        if(k == 1 && n != 0)return true;
        if(k == 1)return false;
        int x = 0;
        boolean b = false;
        while(i < n){
            if(arr.get(i-1) < arr.get(i)){
                x++;
            }else{
                if(x >= 2*k-1)return true;
                if(x >= k-1 && b)return true;
                if(x >= k-1)b = true;
                else b = false;
                x = 0;
            }
            if(x >= 2*k-1)return true;
            if(x >= k-1 && b)return true;
            i++;
        }
        return false;
    }
}