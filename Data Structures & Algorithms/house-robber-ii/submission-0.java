class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int n = nums.length;
        int planA = helper(nums, 0, n - 2);
        int planB = helper(nums, 1, n - 1);
        return Math.max(planA, planB);

    }

    private int helper(int[] nums, int start, int end){
        int len = end - start + 1;
        int[] container = new int[len + 1];

        container[1] = nums[start];
        container[2] = Math.max(nums[start], nums[start + 1]);

        for (int i = 3; i <= len; i ++){
            container[i] = Math.max(container[i - 1], nums[start + i - 1] + container[i - 2]);
        }
        return container[len];
    }
}
