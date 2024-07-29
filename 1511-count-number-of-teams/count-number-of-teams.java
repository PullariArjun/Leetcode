class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        ArrayList<Integer>[] f1 = new ArrayList[n];
        ArrayList<Integer>[] f2 = new ArrayList[n];
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(rating[i] > rating[j]){
                    if(f1[i] == null)f1[i] = new ArrayList<>();
                    f1[i].add(j);
                }
                if(rating[i] < rating[j]){
                    if(f2[i] == null)f2[i] = new ArrayList<>();
                    f2[i].add(j);
                }
            }
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; f1[i] != null && j < f1[i].size(); j++){
                if(f1[f1[i].get(j)] != null)
                ans += f1[f1[i].get(j)].size();
            }
            // System.out.println(ans);
            for(int j = 0; f2[i] != null && j < f2[i].size(); j++){
                if(f2[f2[i].get(j)] != null)
                ans += f2[f2[i].get(j)].size();
            }
        }
        return ans;
    }
}