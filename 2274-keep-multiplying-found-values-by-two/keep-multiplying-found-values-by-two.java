class Solution {
    public int findFinalValue(int[] nums, int original) {
         boolean has[] = new boolean[1001];
         for(int i: nums)has[i] = true;
         while(original < 1001 && has[original]) original *= 2;
         return original;
    }
}