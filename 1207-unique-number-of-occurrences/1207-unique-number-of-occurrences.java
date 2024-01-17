class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int temp[] = new int[2002];
        for(int i: arr)
            temp[i+1000]++;
        Set<Integer> set = new HashSet<>();
        for(int i: temp){
            if(i != 0 && !set.add(i))return false;
        }
        return true;
    }
}