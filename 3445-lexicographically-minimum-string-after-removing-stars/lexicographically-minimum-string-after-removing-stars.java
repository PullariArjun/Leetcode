class pair{
    char let;
    int ind;
    pair(){}
    pair(char let, int ind){
        this.let = let;
        this.ind = ind;
    }
}
class Solution {
    public String clearStars(String s) {
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b)->{
            if(a.let != b.let)return a.let-b.let;
            return b.ind - a.ind;
        });
        int n = s.length();
        boolean marked[] = new boolean[n];
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '*'){
                marked[pq.poll().ind] = true;
                marked[i] = true;
            }else{
                pq.offer(new pair(s.charAt(i), i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(!marked[i])sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}