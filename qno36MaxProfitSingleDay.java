// Implement algorithm to maximize your profit by choosing to buy and sale a stock in single day.

// Answer:;

public class qno36MaxProfitSingleDay {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0; // If array is empty or has less than 2 prices, no profit can be made
        }

        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            // Update minimum price encountered so far
            minPrice = Math.min(minPrice, prices[i]);
            // Calculate current profit if selling at current price
            int currentProfit = prices[i] - minPrice;
            // Update maximum profit if current profit is greater
            maxProfit = Math.max(maxProfit, currentProfit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        qno36MaxProfitSingleDay solution = new qno36MaxProfitSingleDay();
        int[] prices = {7, 1, 5, 3, 6, 4}; // Example input
        int maxProfit = solution.maxProfit(prices);
        System.out.println("Maximum profit: " + maxProfit);
    }
}
