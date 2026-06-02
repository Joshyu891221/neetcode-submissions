class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if(!set.add(num)){ return true; }
            // System.out.print(num);
        }
        
        return false;
    }
}