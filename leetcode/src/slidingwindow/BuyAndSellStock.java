package slidingwindow;

/**
 * 121. best-time-to-buy-and-sell-stock.
 *
 * @link <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/">...</a>
 */
public class BuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int l = 0, profit = 0;
        for (int r=0; r<prices.length; ++r) {
            while (prices[r] < prices[l]) {
                l++;
            }
            profit = Math.max(profit, prices[r] - prices[l]);
        }

        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[] {7, 6, 4, 3, 1}));
    }
}
