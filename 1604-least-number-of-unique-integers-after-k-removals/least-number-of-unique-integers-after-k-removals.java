class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i= 0; i < arr.length; i++){
            if(hs.containsKey(arr[i]))hs.put(arr[i], hs.get(arr[i])+1);
            else hs.put(arr[i], 1);
        }
        ArrayList<Integer> al = new ArrayList<>();
        for(int i: hs.values())al.add(i);
        Collections.sort(al);
        int x = 0;
        for(int i: al){
            if(i > k)return al.size() - x;
            k -= i;
            x++;
        }
        return 0;
    }
}