class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            // Update minimum buying price
            minPrice = Math.min(minPrice, price);

            // Calculate profit if sold today
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}