class Solution {
    List<Integer> ans;
    public void fun(int low, int high, int num, int x){
        if(num > high)return;
        if(x > 10)return;
        if(low <= num && num <= high)ans.add(num);
        fun(low, high, num*10+x, x+1);
    }
    public List<Integer> sequentialDigits(int low, int high) {
        ans = new ArrayList<>();
        for(int i = 1; i <= 10; i++)
            fun(low, high, 0, i);
        Collections.sort(ans);
        return ans;
    }
}