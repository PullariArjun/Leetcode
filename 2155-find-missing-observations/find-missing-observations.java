class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for(int i: rolls)
            sum += i;
        int x = (mean * (n + rolls.length)) - sum;
        if(n * 6 < x || x < n)return new int[0];
        int ans[] = new int[n];
        // System.out.println(x);
        Arrays.fill(ans, 1);
        x -=  n;
        int i = 0;
        while(i < n && x > 0){
            if(x > 5){
                ans[i] += 5;
                x -= 5;
            }else{
                ans[i] += x;
                break;
            }
            i++;
        }
        return ans;

    }
}