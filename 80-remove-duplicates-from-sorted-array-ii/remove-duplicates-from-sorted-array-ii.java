class Solution {
    public int removeDuplicates(int[] arr) {
        int n = arr.length;
        if(n <= 2)return n;
        int i = 0, j = 0;
        if(arr[0] == arr[1]){
            i = 1;
            j = 1;
        }
        else{
            i= 0;
            j = 0;
        }
        while(j < n){
            while(j < n && arr[i] == arr[j])j++;
            if(j < n){

                arr[i+1] = arr[j];
                i++;
                if(j < n-1 && arr[j+1] == arr[j]){
                    arr[i+1] = arr[j];
                    i++;
                }
            }
        }
        return i+1;
    }
}