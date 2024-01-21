class Solution {
    List<Integer> lst = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    int len = -1;
    public void getallsets(int nums[], int n, int start){
        if(start >= n)return;
        Set<Integer> set = new HashSet<>();
        for(int i = start; i < n; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                lst.add(nums[i]);
                len++;
                ans.add(new ArrayList<>(lst));
                getallsets(nums, n, i+1);
                lst.remove(len);
                len--;
            }
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans.clear();
        ans.add(new ArrayList<>());
        getallsets(nums, nums.length, 0);
        return ans;
    }
}