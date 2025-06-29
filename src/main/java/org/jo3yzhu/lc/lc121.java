package org.jo3yzhu.lc;

public class lc121 {

    // 核心贪心策略：
    // 1. 在每一天，记住当天之前最低的价格，在当天模拟卖出即可计算出当天的最大收益，用一个min标志位即可
    // 2. 当然也可以使用模拟当天买入，但是就需要维护当天之后的最高价格，用一个max标志位，代码相对麻烦点

    public int maxProfit(int[] prices) {
        int answer = 0;
        int bestAsk = prices[0];
        for (int price : prices) {
            bestAsk = Math.min(price, bestAsk);
            int profit = price - bestAsk;
            answer = Math.max(profit, answer);
        }
        return answer;
    }

    public int maxProfit2(int[] prices) {
        int answer = 0;
        int bestBid = prices[prices.length - 1];
        for (int i = prices.length - 1; i >= 0; --i) {
            int price = prices[i];
            bestBid = Math.max(price, bestBid);
            int profit = bestBid - price;
            answer = Math.max(profit, answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new lc121().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new lc121().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new lc121().maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new lc121().maxProfit2(new int[]{7, 6, 4, 3, 1}));
    }
}
