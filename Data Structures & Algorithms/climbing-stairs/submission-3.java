class Solution {
    private int res = 0;
    public int climbStairs(int n) {
        if(n <= 2){return n;}
        // int[] ways = new int[n + 1];
        int a = 1;
        int b = 2;
        int ans = 0;
        for (int i = 3; i <= n; i++){
            ans = a + b;
            a = b;
            b = ans;
        }
        return ans;
    }
}
