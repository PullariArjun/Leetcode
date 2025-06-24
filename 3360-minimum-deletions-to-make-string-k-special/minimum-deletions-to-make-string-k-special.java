class Solution {
    public int minimumDeletions(String word, int k) {
        int arr[] = new int[26];
        int max = 0;
        for(char c: word.toCharArray()){
            arr[c-'a']++;
            max = Math.max(max, arr[c-'a']);
        }
        if(max == word.length() || max <= k)return 0;
        int i = 0, j = k, ans = Integer.MAX_VALUE;
        while(j <= max){
            int temp = 0;
            for(int x: arr){
                if(x < i)temp += x;
                if(x > j)temp += (x-j);
            }
            i++;
            j++;
            ans = Math.min(ans, temp);
        }
        return ans;
    }
}