class Solution {
    public int specialTriplets(int[] arr) {
        int n = arr.length;
        int mod = (int)(1e9+7);
        Map<Integer, Integer> map = new HashMap<>();
        // System.out.println(n);
        int prev[] = new int[n];
        for(int i = 0; i < n; i++){
            prev[i] = map.getOrDefault(arr[i]*2, 0);
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        // System.out.println(map);
        long ans = 0;
        map.clear();
        int next[] = new int[n];
        for(int i = n-1; i >= 0; i--){
            next[i] = map.getOrDefault(arr[i]*2, 0);
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        for(int i = 0; i < n; i++){
            long x = (long)(((long)(prev[i]%mod) * (long)(next[i]%mod))%mod);
            ans = (ans + x)%mod;
        }
        return (int)ans;

    }
}