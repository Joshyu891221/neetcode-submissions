class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        
        for (int pile : piles) {
            if ( pile > r){
                r = pile;
            }
        }
        int res = r;
        while (l <= r){
            int m = (l + r) / 2;
            int time = calculate(m, piles);
            if(time > h){
                l = m + 1;
            }else {
                res = m;
                r = m - 1;
            }
        }
        return res;
    }
    public int calculate(int k, int[] piles){
        int time = 0;
        for (int pile : piles){
            time += (pile + k - 1) / k;
        }
        return time;
    }
}
