class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int arr[] = new int[n];
        for(List<Integer> i: edges){
            arr[i.get(1)]++;
        }
        List<Integer> ans = edges.get(0);
        ans.clear();
        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                ans.add(i);
            }
        }
        return ans;
    }
}