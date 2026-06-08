class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 0;
        int profit = 0;
        int maxProfit = 0;
        while(r<prices.length){
          profit = prices[r] - prices[l];
          if(profit<0){
            l = r;
          }
          maxProfit = Math.max(profit,maxProfit);
          r++;
        }
        return maxProfit;
    }
}
