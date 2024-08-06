class Solution {

    public void fun(int n, int num, List<Integer> ans){
        if(num > n)return;
        ans.add(num);
        for(int i = 0; i < 10; i++){
            fun(n, num*10+i, ans);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            fun(n, i, ans);
        }
        return ans;
    }
}