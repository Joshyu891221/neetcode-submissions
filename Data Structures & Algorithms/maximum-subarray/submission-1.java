class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i] + count;
            res = Math.max(num, res);
            count = Math.max(num, 0);
        }
        return res;
    }
}
