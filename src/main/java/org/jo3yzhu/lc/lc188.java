package org.jo3yzhu.lc;

public class lc188 {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // 第i天进行了k次交易后持股或者不持股的状态（因为不能参与多笔交易，所以只有1或者0的状态）
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < k + 1; ++i) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0]; // 一次交易是买了之后还要卖，所以合法
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < k + 1; ++j) {
                // 不持股：可以是昨天就不持股，或今天卖出，卖出后才算是一次交易
                dp[i][j][0] = dp[i - 1][j][0];
                if (j > 0) {
                    dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j - 1][1] + prices[i]);
                }

                // 持股：可以昨天就持股，或今天买入
                dp[i][j][1] = dp[i - 1][j][1];
                dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    public static void main(String[] args) {

    }
}
