class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prefix = 1;
        int surfix = 1;
        // res[0] = 1;
        for (int i = 0; i < nums.length; i++){
            res[i] = prefix;
            prefix *= nums[i]; 
        }
        for (int i = nums.length - 1; i > -1; i --){
            res[i] *= surfix;
            surfix *= nums[i];
        }
        return res;
    }
}  
