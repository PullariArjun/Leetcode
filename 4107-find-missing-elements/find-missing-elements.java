class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int min = nums[0], max = nums[0];
        for (int i: nums){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        for(int i = min+1; i < max; i++){
            boolean b = false;
            for(int num: nums){
                b = num == i?true:b;
            }
            if(!b)ans.add(i);
        }
        return ans;
    }
}