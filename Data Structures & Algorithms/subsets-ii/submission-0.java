class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, res, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> ans){
        res.add(new ArrayList<>(ans));

        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]) continue;

            ans.add(nums[i]);

            dfs(nums, i + 1, res, ans);

            ans.remove(ans.size() - 1);
        }
    }
}
