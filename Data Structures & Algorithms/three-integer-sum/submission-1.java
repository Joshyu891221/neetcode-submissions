class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int curr_index = 0;
        while (curr_index < nums.length - 2 && nums[curr_index] <= 0){
            System.out.print('a');
            int target = 0 - nums[curr_index];
            int l = curr_index + 1;
            int r = nums.length - 1;
            if (curr_index > 0 && nums[curr_index] == nums[curr_index - 1]){ 
                curr_index ++;
                continue;}

            while (l < r){
                if (nums[l] + nums[r] > target){
                    r--;
                }else if(nums[l] + nums[r] < target){
                    l++;
                }else{
                    res.add(new ArrayList<>(Arrays.asList(nums[curr_index], nums[l], nums[r])));
                    r--;
                    l++;

                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }
            }
            curr_index ++;
        }
        
        return res;
    }
}
