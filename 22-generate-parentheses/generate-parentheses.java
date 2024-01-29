class Solution {
    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int len = -1;
    void fun(int open, int close){
        if(open == 0 && close == 0){
            ans.add(sb.toString());
            return;
        }
        if(open > 0){
            sb.append('(');
            len++;
            fun(open-1, close);
            sb.deleteCharAt(len--);
        }
        if(open < close){
            sb.append(')');
            len++;
            fun(open, close-1);
            sb.deleteCharAt(len--);
        }
    }
    public List<String> generateParenthesis(int n) {
        ans.clear();
        fun(n, n);
        return ans;
    }
}