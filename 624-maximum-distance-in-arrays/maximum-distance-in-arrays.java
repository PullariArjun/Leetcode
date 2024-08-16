class Solution {
    public int getmin(List<Integer> lst){
        return lst.get(0);
    }
    public int getmax(List<Integer> lst){
        return lst.get(lst.size()-1);
    }
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        int min = (int)(1e6);
        int minind = -1;
        for(int i = 0; i < n; i++){
            if(getmin(arrays.get(i)) < min){
                min = getmin(arrays.get(i));
                minind = i;
            }
        }
        int max = (int)(-1e6);
        int maxind = -1;
        for(int i = 0; i < n; i++){
            if(getmax(arrays.get(i)) > max){
                max = getmax(arrays.get(i));
                maxind = i;
            }
        }
        if(minind != maxind){
            // System.out.println(min+" "+max);
            return max-min;
        }
        int secondmin = (int)(1e6);
        for(int i = 0; i < n; i++){
            if(i != minind){
                secondmin = Math.min(secondmin, getmin(arrays.get(i)));
            }
        }

        int secondmax = (int)(-1e6);
        for(int i = 0; i < n; i++){
            if(i != maxind){
                secondmax =  Math.max(secondmax, getmax(arrays.get(i)));
            }
        }
        // System.out.println(min+" "+max+" "+secondmin+" "+secondmax);
        return Math.max(
            Math.abs(secondmax - min),
            Math.abs(max - secondmin)
        );
    }
}