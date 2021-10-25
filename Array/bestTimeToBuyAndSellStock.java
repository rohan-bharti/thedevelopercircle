/**
 * Best Time to Buy and Sell Stock. The idea is to find the minimum buy day and max sell day.
 * Once we get the min, we check the index of the sell day is after the buy day. With that we keep a track
 * of maxProfit.
 *
 * Average - O(N) time | O(1) space
 */
class bestTimeToBuyAndSellAStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyDay = 0;

        for(int i=0; i<prices.length; i++) {
            if (prices[i] < prices[buyDay]) {
                buyDay = i;
            }
            else if (i > buyDay && prices[buyDay] < prices[i]) {
                maxProfit = Math.max(maxProfit, prices[i] - prices[buyDay]);
            }
        }

        return maxProfit;
    }
}