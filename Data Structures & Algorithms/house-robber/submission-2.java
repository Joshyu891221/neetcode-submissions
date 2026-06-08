class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){ return nums[0];}
        if(nums.length == 2){ return Math.max(nums[0], nums[1]);}
        int[] container = new int[nums.length + 1];
        container[1] = nums[0];
        container[2] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++){
            container[i + 1] = nums[i] + Math.max(container[i - 1], container[i - 2]);

        }
        return Math.max(container[nums.length], container[nums.length - 1]);
    }
}
