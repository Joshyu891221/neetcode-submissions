class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (1 + n) / 2;
        for ( int num : nums){
            total -= num;
        }
        return total;
    }
}
