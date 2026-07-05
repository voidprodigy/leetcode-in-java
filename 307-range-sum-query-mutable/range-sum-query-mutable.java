class NumArray {

    private int[] nums;
    private int[] bit;
    private int n;

    public NumArray(int[] nums) {
        n = nums.length;
        this.nums = nums.clone();
        bit = new int[n + 1];

        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    // Add delta to Fenwick Tree
    private void add(int index, int delta) {

        while (index <= n) {
            bit[index] += delta;
            index += index & (-index);
        }
    }

    public void update(int index, int val) {

        int diff = val - nums[index];

        nums[index] = val;

        add(index + 1, diff);
    }

    // Prefix sum from index 0 to index
    private int prefixSum(int index) {

        int sum = 0;

        while (index > 0) {
            sum += bit[index];
            index -= index & (-index);
        }

        return sum;
    }

    public int sumRange(int left, int right) {

        return prefixSum(right + 1) - prefixSum(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */