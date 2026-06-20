class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(candidates);
        dfs(candidates, target, 0, ans, res);
        return res;


    }

    public void dfs(int[] candidates, int target, int index, List<Integer> ans, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(target - candidates[i] < 0){
                return;
            }

            if(i > index && candidates[i] == candidates[i - 1]) continue;

            ans.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, ans, res);
            ans.remove(ans.size() - 1);
        }
    }
}
