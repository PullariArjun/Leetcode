class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> win = new ArrayList<>(), lose = new ArrayList<>();
        int[] wins = new int[100001];
        int[] loses = new int[100001];
        for(int[] i: matches){
            wins[i[0]]++;
            loses[i[1]]++;
        }
        for(int i = 0; i < wins.length; i++){
            if(wins[i] != 0 && loses[i] == 0)win.add(i);
            if(loses[i] == 1)lose.add(i);
        }
        ans.add(win);
        ans.add(lose);
        return ans;
    }
}