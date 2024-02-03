class Solution {
    public long maximumSubarraySum(int[] ar, int k) {
        HashMap<Integer, ArrayList<Integer>> hs = new HashMap<>();
        int n = ar.length;
        for(int i = 0; i < n; i++){
            if(hs.containsKey(ar[i]))
                hs.get(ar[i]).add(i);
            else{
                ArrayList<Integer> al = new ArrayList<>();
                al.add(i);
                hs.put(ar[i], al);
            }
        }
        long arr[] = new long[n];
        long z = 0;
        for(int i = 0; i < n; i++){
            z+=(long)ar[i];
            arr[i] = z;
        }
        long x = 0, max = Long.MIN_VALUE;
        for(int a: hs.keySet()){
            if(hs.containsKey(a-k)){
                ArrayList<Integer> l1 = hs.get(a), l2 = hs.get(a-k);
                int l1s = l1.size(), l2s = l2.size();
                for(int i = 0; i < l1s; i++){
                    for(int j = 0; j < l2s; j++){
                        
                        if(l1.get(i) < l2.get(j)){
                            if(l1.get(i) == 0)x = arr[l2.get(j)];
                            else x = arr[l2.get(j)]-arr[l1.get(i)-1];
                        }
                        else{
                            if(l2.get(j) == 0)x = arr[l1.get(i)];
                            else x = arr[l1.get(i)] - arr[l2.get(j)-1];
                        }
                        max = Math.max(x, max);
                    }
                }
            }
        }
        if(max == Long.MIN_VALUE)return 0;
        return max;
        //18999999810
            
    }
}