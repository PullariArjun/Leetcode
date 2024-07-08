class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> que = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            que.offer(i);
        }
        while(n > 1){
            int x = k;
            while(x > 1){
                que.offer(que.poll());
                x--;
            }
            que.poll();
            n--;
        // System.out.println(que);
        }
        return que.poll();
    }
}