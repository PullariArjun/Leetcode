class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int len = 0, f = 0;
        for(char c: s.toCharArray()){
            if(c == ' ' && f == 0 && len != 0){
                sb.append(' ');
                f = 1;
                len++;
            }
            if(c != ' '){
                sb.append(c);
                f = 0;
                len++;
            }
        }
        if(sb.charAt(len-1) == ' ')sb.deleteCharAt(len-1);
        s = sb.toString();
        String arr[] = s.split(" ");
        int i = 0, j = arr.length-1;
        while(i < j){
            s = arr[i];
            arr[i] = arr[j];
            arr[j] = s;
            i++;
            j--;
        }
        sb = new StringBuilder();
        for(String x: arr)sb.append(x+" ");
        return sb.substring(0, sb.length()-1);
    }
}