class NumArray {
    int seg[], arr[], n;

    public NumArray(int[] nums) {
        this.arr = nums;
        this.n = nums.length;
        this.seg = new int[4 * nums.length];
        build(0, 0, n-1);
        
    }
    public void build(int ind, int low, int high){
        if(low == high){
            seg[ind] = arr[low];
            return;
        }
        int mid = (low + high)/2;
        build(2*ind+1, low, mid);
        build(2*ind+2, mid+1, high);
        seg[ind] = seg[2*ind+1] + seg[2*ind+2];
    }
    public int query(int ind, int low, int high, int x, int y){
        if (x <= low && high <= y) return seg[ind];
        if(high < x || low > y)return 0;
        int mid = (low + high)/2;
        int aa = query(2*ind+1, low, mid, x, y);
        int bb = query(2*ind+2, mid+1, high, x, y);
        return aa+bb;
    }
    public void updateSeg(int ind, int low, int high, int sum, int upind){
        if(upind < low || upind > high)return;
        seg[ind] += sum;
        if(low == high)return;
        int mid = (low + high)/2;
        if(upind <= mid)
            updateSeg(2*ind+1, low, mid, sum, upind);
        else
            updateSeg(2*ind+2, mid+1, high, sum, upind);
    }
    public void update(int index, int val) {
        updateSeg(0, 0, n-1, val - arr[index], index);
        arr[index] = val;
    }
    
    public int sumRange(int left, int right) {
        return query(0, 0, n-1, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */