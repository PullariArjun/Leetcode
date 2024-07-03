class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1)return s;
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int increment = 0, decrement = 2*(numRows-1);
        for(int i = 0; i < numRows; i++){
            int x = i;
            while(x < len){
                if(decrement != 0 && x < len){
                    sb.append(s.charAt(x));
                    x += decrement;
                }
                if(increment != 0 && x < len){
                    sb.append(s.charAt(x));
                    x += increment;
                }
            }
            increment += 2;
            decrement -= 2;
        }
        return sb.toString();
    }
}