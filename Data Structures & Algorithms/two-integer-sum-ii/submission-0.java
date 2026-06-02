class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (l < r && numbers[l] + numbers[r] != target) {
            while (l < r && numbers[l] + numbers[r] < target){
                l ++;
            }
            while (l < r && numbers[l] + numbers[r] > target){
                r --;
            }
        }
        return new int[]{l + 1, r + 1};
        
    }
}
