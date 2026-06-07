class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        bt(res, target, curr, nums, 0);
        return res;
    }

    public void bt(List<List<Integer>> arr, int target, List<Integer> curr, int[] nums, int start){
        if (target == 0) {

            arr.add(new ArrayList<>(curr)); 
            return;
        }

        
        for (int i = start; i < nums.length; i++) {
              
            if (nums[i] > target) {break;}

            curr.add(nums[i]);
            
            bt(arr, target - nums[i], curr, nums, i);

            curr.remove(curr.size() - 1); 
        }
        // return;
    }
}
