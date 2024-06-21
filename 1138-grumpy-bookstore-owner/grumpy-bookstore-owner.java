class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0, n = customers.length;
        for(int i = 0; i < n; i++){
            if(grumpy[i] == 0 || i < minutes)ans += customers[i];
        }
        int i = 0, j = minutes, trav = ans;
        while(j < n){
            if(grumpy[i] == 1)trav -= customers[i];
            if(grumpy[j] == 1)trav += customers[j];
            ans = Math.max(ans, trav);
            i++;
            j++;
        }
        return ans;
    }
}