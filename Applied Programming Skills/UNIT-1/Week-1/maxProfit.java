class MaxProfit {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {10, 20, 30, 40, 50};
        MaxProfit obj = new MaxProfit();
        int result = obj.maxProfit(prices);
        System.out.println("Maximum Profit = " + result);
    }
}
