class Solution {
    public List<String> stringSequence(String target) {

        List<String> ans = new ArrayList<>();
        int n = target.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < n){
            char c = 'a';
            while(c != target.charAt(i)){
                sb.append(c);
                ans.add(sb.toString());
                sb.deleteCharAt(i);
                c++;
            }
            sb.append(c);
            ans.add(sb.toString());
            i++;
        }
        return ans;
        
    }
}