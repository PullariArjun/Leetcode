class Solution {
    public int numberOfSubstrings(String s, int k) {
        int i = 0, j = 0;
        int arr[] = new int[26];
        int n = s.length();
        int ans = 0;
        
        if(k == 1)return (n * (n+1))/2;
        while(j < n){
            arr[s.charAt(j)-'a']++;
            while(arr[s.charAt(j)-'a'] >= k){
                ans += n-j;
                arr[s.charAt(i)-'a']--;
                i++;
            }
            j++;
        }
        
        return ans;
    }
}