class Solution {
    public int lengthOfLongestSubstring(String s) {
        int arr[] = new int[250];
        int n = s.length(), ans = 0;
        int i = 0, j = 0;
        while(j < n){
            if(arr[(int)s.charAt(j)] == 1){
                ans = Math.max(ans, j-i);
                while(s.charAt(i) != s.charAt(j)){
                    arr[(int)s.charAt(i)]--;
                    i++;
                }
                j++;
                i++;
            }
            else{
                arr[(int)s.charAt(j)]++;
                j++;
            }
        }
        ans = Math.max(ans, j-i);
        return ans;
        
    }
}