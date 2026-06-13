class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        res.add(new ArrayList<>(ans));
        dfs(nums, ans, 0);
        return res;
    }

    public void dfs(int[] nums, List<Integer> ans, int start){
        

        for(int i = start; i < nums.length; i++){
            ans.add(nums[i]);
            res.add(new ArrayList<>(ans));
            dfs(nums, ans, i + 1);
            ans.remove(ans.size() - 1);
        }
    }
}
