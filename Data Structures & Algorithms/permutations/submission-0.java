class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, ans, visited);
        return res;
    }
    public void dfs(int[] nums, List<Integer> ans, boolean[] visited){
        if(ans.size() == nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                ans.add(nums[i]);
                visited[i] = true;
                dfs(nums, ans, visited);
                ans.remove(ans.size() - 1);
                visited[i] = false;
            }
            
        }
    }
}
