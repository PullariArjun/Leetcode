class Pair{
    String str;
    int steps;
    Pair(){}
    Pair(String str, int steps){
        this.str = str;
        this.steps = steps;
    }
    public String toString(){
        return this.str + " "+ this.steps;
    }
}
class Solution {
    public boolean canTravel(String word1, String word2){
        int diff = 0;
        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i))diff++;
            if(diff > 1)return false;
        }
        return true;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord))return 0;
        Queue<Pair> que = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();
        que.offer(new Pair(beginWord, 1));
        vis.add(beginWord);
        while(!que.isEmpty()){
            Pair poll = que.poll();
            // System.out.println(poll);
            for(String s: wordList){
                if(!vis.contains(s) && canTravel(poll.str, s)){
                    if(s.equals(endWord))return poll.steps+1;
                    vis.add(s);
                    que.offer(new Pair(s, poll.steps+1));

                }
            }
        }
        return 0;
        
    }
}