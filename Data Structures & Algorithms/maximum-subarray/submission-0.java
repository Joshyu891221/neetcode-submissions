class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int curr_count = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            curr_count = Math.max(num, curr_count + num);

            res = Math.max(res, curr_count);
        }
        return res;
    }
}
