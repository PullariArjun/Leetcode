class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        // System.out.println(Arrays.toString(costs));
        for(int i = 0; i < costs.length; i++){
            if(coins < costs[i])return Math.max(0, i);
            coins -= costs[i];
        }
        return costs.length;
    }
}