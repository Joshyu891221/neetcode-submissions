class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2){ return 0;}
        int[] pair = new int[2];
        pair[0] = prices[0];
        int max_profit = 0;
        // int buy = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++){
            if( prices[i] < pair[0]){
                pair[0] = prices[i];
                pair[1] = 0;
                System.out.println("buy price is " + String.valueOf(pair[0]));
            }else if (prices[i] > pair[1]){
                pair[1] = prices[i];
                System.out.println("sell price is " + String.valueOf(pair[1]));
                max_profit = Math.max(max_profit, pair[1] - pair[0]);
            }
        }
        return max_profit;
    }
}
