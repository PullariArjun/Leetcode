class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        int len = s.length();
        if(len%k != 0 || len < k)return false;
        if(len == k)return true;
        HashMap<String, Integer> map = new HashMap<>();
        k = len/k;
        for(int i = 0; i < len; i += k){
            map.put(s.substring(i, i+k), map.getOrDefault(s.substring(i, i+k), 0)+1);
        }
        // System.out.println(map);
        for(int i = 0; i < len; i+=k){
            String x = t.substring(i, i+k);
            if(!map.containsKey(x))return false;
            if(map.get(x) == 0)return false;
            map.put(x, map.get(x)-1);
        }
        return true;
    }
}