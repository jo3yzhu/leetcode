package org.jo3yzhu.lc;

public class lc123 {

    // 和lc122不一样的地方是这里最多交易两次，lc122是无限次交易，甚至可以当天买当天卖
    // 之前的dp定义是第i天不持仓或持仓的**最大**现金: dp[i][0]/dp[i][1]
    // 之前的base case很好理解，第一天只能选买或者不买，只有一种情况所以肯定是最大现金
    // dp[0][0] = 0;
    // dp[0][1] = -prices[0];
    // 之前的状态转移方程，因为每天都可以选择要不要操作（操作次数是无限的），所以直接选择当天最赚钱的策略即可（最优子结构）
    // dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] - prices[i])
    // dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + prices[i])
    // 注意这个状态转移方程中的逻辑，实际上已经进行了“买”和“卖”只能交替运行的限制
    // 如果只能交易两次的话，似乎加一维就行了，意为已经进行了多少次交易。
    // base case:
    // dp[0][0][0] = 0;
    // dp[0][1][1] = -prices[0];
    // 状态转移方程：
    // dp[i][0][d] = d < 2 ? max(dp[i - 1][1][d - 1] + prices[i], dp[i - 1][0][d]) :
    // dp[i][1][d] = max(dp[i - 1][0][d - 1] - prices[i], dp[i - 1][1][d])
    // 但是这里的问题似乎是：初始状态到底应该怎么定义？
    // 如果会只是简单的无脑定义成-0，-1或者负无穷，在状态转移方程内就会出现语义对不上的问题
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][5];
        int answer = 0;
        dp[0][0] = 0;
        dp[0][1] = -prices[0]; // 第一次持有
        dp[0][2] = 0; // 第一次不持有
        dp[0][3] = -prices[0]; // 第二次持有
        dp[0][4] = 0; // 第二次不持有

        for (int i = 1; i < n; ++i) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
            answer = Math.max(dp[i][4], answer);
            answer = Math.max(dp[i][2], answer);
        }


        return answer;
    }


    public static void main(String[] args) {
        System.out.println(new lc123().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(new lc123().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new lc123().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
