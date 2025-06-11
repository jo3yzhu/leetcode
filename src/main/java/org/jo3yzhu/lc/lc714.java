package org.jo3yzhu.lc;

public class lc714 {
    public int maxProfit(int[] prices, int fee) {
        // definition:
        // dp[i][0] = the max cash in i-th day with no stock
        // dp[i][1] = the max cash in i-th day with stock

        // base case:
        // dp[0][0] = 0;
        // dp[0][1] = -prices[0];

        // transfer:
        // dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]）
        // dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee）

        // 注意：这里要考虑到手续费是在卖还是买的时候给，题目的意思应该是卖的时候

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee); // 今天没持仓，要么昨天也没持仓，要么今天卖
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee); // 今天有持仓，要么昨天就有持仓，要么今天买
        }

        // 返回最后一天持有现金的情况
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {

    }
}
