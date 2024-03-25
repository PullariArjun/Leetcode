class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            if(!set.add(i))
                ans.add(i);
        }
        return ans;
    }
}