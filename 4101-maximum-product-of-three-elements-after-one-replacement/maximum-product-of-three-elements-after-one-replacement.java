class Solution {
    public long maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long a1 = (long)nums[0] * (long)nums[1] * -100000L;
        // System.out.println(nums[0]+ " "+nums[1]);
        long a2 = (long)nums[0] * (long)nums[1] * 100000L;
        long a3 = (long)nums[n-1] * (long)nums[n-2] * -100000L;
        long a4 = (long)nums[n-1] * (long)nums[n-2] * 100000L;
        long a5 = (long)nums[0] * (long)nums[n-1] * -100000L;
        // System.out.println(a1+" "+a2+" "+a3+" "+a3);
        return Math.max(a5, Math.max(Math.max(a1, a2), Math.max(a3, a4)));
    }
}