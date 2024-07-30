class Solution {
    public String fun(String s){
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0, j= 0, cnt = 0;
        while(j < n){
            if(s.charAt(i) == s.charAt(j)){
                cnt++;
                j++;
            }
            else{
                sb.append(cnt);
                sb.append(s.charAt(i));
                cnt = 0;
                i = j;
            }
        }
        sb.append(cnt);
        sb.append(s.charAt(i));
        return sb.toString();
    }
    public String countAndSay(int n) {
        if(n == 1)return "1";
        return fun(countAndSay(n-1));
    }
}