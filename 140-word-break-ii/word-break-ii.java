class Solution {
    Set<String> set;
    List<List<String>> ans;
    List<String> lst;
    int len = -1;
    public void fun(String s, int n, int start){
        if(start == n){
            ans.add(new ArrayList<>(lst));
            return;
        }
        for(int i = start+1; i <= n; i++){
            String x = s.substring(start, i);
            if(set.contains(x)){
                lst.add(x);
                len++;
                fun(s, n, i);
                lst.remove(len);
                len--;
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        ans = new ArrayList<>();
        lst = new ArrayList<>();
        for(String str: wordDict)set.add(str);


        fun(s, s.length(), 0);


        List<String> finalans = new ArrayList<>();
        for(List<String> list: ans){
            StringBuilder sb = new StringBuilder();
            for(String str: list){
                sb.append(str);
                sb.append(" ");
            }
            finalans.add(sb.toString().trim());
        }
        return finalans;
    }
}