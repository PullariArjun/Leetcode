class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum =0, n = nums.length;
        Arrays.sort(nums);
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        for(int i = 0; i < n; i++){
            sum += nums[i];
            if(nums[i]%3 == 1)one.add(nums[i]);
            else if(nums[i]%3 == 2) two.add(nums[i]);
        }
        int rem = sum%3;
        if(rem == 1){
            int x1 = Integer.MAX_VALUE, x2 = Integer.MAX_VALUE;
            if(one.size() >= 1)x1 = one.get(0);
            if(two.size() >= 2)x2 = two.get(0) + two.get(1);
            sum -= Math.min(x1, x2);
        } else if(rem == 2) {
            int x1 = Integer.MAX_VALUE, x2 = Integer.MAX_VALUE;
            if(two.size() >= 1)x1 = two.get(0);
            if(one.size() >= 2)x2 = one.get(0) + one.get(1);
            sum -= Math.min(x1, x2);
        }
        return sum;
    }
}