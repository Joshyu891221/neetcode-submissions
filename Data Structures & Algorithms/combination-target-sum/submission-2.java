class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        dfs(nums, target, ans, 0);
        return res;
    }

    public void dfs(int[] nums, int target, List<Integer> ans, int start){
        if(target == 0){
            res.add(new ArrayList<>(ans));
            return;
        }

        if(target < 0){
            return;
        }
        for(int i = start; i < nums.length; i++){
            ans.add(nums[i]);
            dfs(nums, target - nums[i], ans, i);
            ans.remove(ans.size() - 1);
        }

    }
}

