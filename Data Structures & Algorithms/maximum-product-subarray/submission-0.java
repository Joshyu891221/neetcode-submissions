class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0]; 
        int positive = nums[0];
        int negative = nums[0];

        for(int i = 1; i < nums.length; i++){
            
            int tempp = positive;
            positive = Math.max(nums[i], Math.max(nums[i] * negative,  nums[i] * positive));
            negative = Math.min(nums[i], Math.min(nums[i] * negative,  nums[i] * tempp));
            

            res = Math.max(res, positive);
        }

        return res;
    }
}
