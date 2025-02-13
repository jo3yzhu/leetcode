package org.jo3yzhu.lc;

import java.util.Arrays;

public class lc322 {

    public int coinChange(int[] coins, int amount) {
        // dp[i]: the min number of coins for amount i

        // case: {1,2,5} 11
        // dp[0] = 0;
        // dp[1] = 1;
        // dp[2] = 1;
        // dp[3] = min(dp[3] + dp[0], dp[2] + dp[1])
        // dp[4] = min(dp[4] + dp[0], dp[3] + dp[1], dp[2] + dp[2])
        // dp[5] = 1;
        // dp[6] = min(dp[6] + dp[0], dp[5] + dp[1], dp[4] + dp[2], dp[3] + dp[3])
        // ..

        // case: {1} 10000
        // dp[0] = 0;
        // dp[1] = 1;
        // dp[2] = min(dp[2] + dp[0], dp[1] + dp[1])
        // dp[3] = min(dp[3] + dp[0], dp[2] + dp[1])
        // dp[4] = min(dp[4] + dp[0], dp[3] + dp[1], dp[2] + dp[2])
        // dp[5] = min(dp[5] + dp[0], dp[4] + dp[1], dp[3] + dp[2])
        // dp[6] = min(dp[6] + dp[0], dp[5] + dp[1], dp[4] + dp[2], dp[3] + dp[3])

        int[] dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            if (coin > amount) {
                continue;
            }
            dp[coin] = 1;
        }

        for (int i = 1; i <= amount; ++i) {
            if (dp[i] != Integer.MAX_VALUE) {
                continue;
            }
            for (int j = i - 1; j >= i / 2; --j) {
                int k = i - j;
                if (dp[j] == Integer.MAX_VALUE || dp[k] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[j] + dp[k]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
//        System.out.println(new lc322().coinChange(new int[]{1, 2, 5}, 1));
//        System.out.println(new lc322().coinChange(new int[]{1, 2, 5}, 3));
//        System.out.println(new lc322().coinChange(new int[]{1, 2, 5}, 4));
//        System.out.println(new lc322().coinChange(new int[]{1, 2, 5}, 5));
//        System.out.println(new lc322().coinChange(new int[]{1, 2, 5}, 11));
//        System.out.println(new lc322().coinChange(new int[]{4, 2, 8}, 12));
//        System.out.println(new lc322().coinChange(new int[]{4, 2, 8}, 13));
//        System.out.println(new lc322().coinChange(new int[]{1}, 0));
//        System.out.println(new lc322().coinChange(new int[]{2147483647}, 2));
        System.out.println(new lc322().coinChange(new int[]{1}, 10000));
    }
}
