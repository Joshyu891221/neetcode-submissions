class Solution {
    private int res = 0;
    public int climbStairs(int n) {
        if(n <= 2){return n;}
        int[] ways = new int[n + 1];
        ways[1] = 1;
        ways[2] = 2;
        for (int i = 3; i <= n; i++){
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n];
    }
    // public void dfs(int target){
    //     if (target == 0){
    //         res++;
    //         return;
    //     }else if(target < 0){
    //         return;
    //     }

    //     for (int i = 1; i < 3; i++){
    //         dfs(target - i);
    //     }
    // }
}
