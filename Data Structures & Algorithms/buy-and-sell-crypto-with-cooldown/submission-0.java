class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;
        int hold = 0 - prices[0];
        int sold = 0;
        int cool = 0;

        for(int i = 1; i < prices.length; i++){
            int prevHold = hold;
            int prevSold = sold;
            int prevCool = cool;

            sold = prevHold + prices[i];
            cool = Math.max(prevSold, prevCool);
            hold = Math.max(prevHold, prevCool - prices[i]);
        }
        return Math.max(sold, cool);
    }
}
