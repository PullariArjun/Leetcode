class Trie{
    Trie[] arr;
    Trie(){
        this.arr = new Trie[2];
    }
}
class Solution {
    public void insert(int val, Trie node){
        Trie temp = node;
        for(int i = 31; i >= 0; i--){
            int x = ((1 << i) & val) > 0?1:0;
            if(temp.arr[x] == null)temp.arr[x] = new Trie();
            temp = temp.arr[x];
        }
    }
    public int getXor(int val, Trie node){
        Trie temp = node;
        int ans = 0;
        for(int i = 31; i >= 0; i--){
            int x = ((1 << i) & val) > 0?1: 0;
            if(x == 0){
                if(temp.arr[1] != null){ 
                    ans = (ans | (1 << i));
                    temp = temp.arr[1];
                }else{
                    temp = temp.arr[0];
                }
            }else{
                if(temp.arr[0] != null){ 
                    ans = (ans | (1 << i));
                    temp = temp.arr[0];
                }else{
                    temp = temp.arr[1];
                }
            }
        }
        return ans;
    }
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int i: nums)insert(i, trie);
        int ans = 0;
        for(int i: nums){
            ans = Math.max(ans, getXor(i, trie));
        }
        return ans;

    }
}