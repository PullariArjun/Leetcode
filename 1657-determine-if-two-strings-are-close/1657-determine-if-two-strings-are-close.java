class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(char c: word1.toCharArray())arr1[c-'a']++;
        for(char c: word2.toCharArray())arr2[c-'a']++;
        HashMap<Integer, Integer> hs1 = new HashMap<>();
        HashMap<Integer, Integer> hs2 = new HashMap<>();
        for(int i = 0; i < 26; i++){
            if((arr1[i] > 0 && arr2[i] == 0) || (arr1[i] == 0 && arr2[i] > 0))return false;
        }
        for(int i: arr1){
            if(i != 0){
                if(hs1.containsKey(i))hs1.put(i, hs1.get(i)+1);
                else hs1.put(i, 1);
            }
        }
        for(int i: arr2){
            if(i != 0){
                if(hs2.containsKey(i))hs2.put(i, hs2.get(i)+1);
                else hs2.put(i, 1);
            }
        }
        for(int i: hs1.keySet()){
            if(!(hs2.containsKey(i) && hs2.get(i) == hs1.get(i)))return false;
        }
        return true;
    }
}