class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<Integer> pq = new PriorityQueue<>((a, b)->{
            if(Math.abs(x-a) != Math.abs(x-b))return Math.abs(x-a) - Math.abs(x-b);
            return a-b;
        });
        for(int i: arr)pq.offer(i);
        List<Integer> lst = new ArrayList<>();
        while(k-->0)lst.add(pq.poll());
        Collections.sort(lst);
        return lst;
    }
}