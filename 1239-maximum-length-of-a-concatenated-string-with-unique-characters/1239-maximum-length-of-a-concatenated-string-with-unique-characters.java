class Solution {
    int freq[] = new int[26];
    public int fun(StringBuilder sb){
        int n = sb.length();
        for(int i = 0; i < n; i++){
            if(freq[sb.charAt(i)-'a'] == 1)return -1;
            freq[sb.charAt(i)-'a'] = 1;
        }
        return n;
    }
    public int fun(List<String> arr, int n, int size){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            if((n&(1<<i)) > 0){
                sb.append(arr.get(i));
            }
        }
        Arrays.fill(freq, 0);
        return fun(sb);
    }
    public int maxLength(List<String> arr) {
        int n = arr.size();
        int a = (1 << (n+1));
        int max = 0;
        for(int i = 0; i < a; i++){
            max = Math.max(max, fun(arr, i, n));
        }
        return max;
    }
}