package org.jo3yzhu.lc;

public class lc5 {

    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = s.substring(0, 1);
        int maxLen = 1;
        boolean[][] dp = new boolean[n][n];
        // dp[i][j]表示s[i]到s[j]这个子串是否是回文串，是则为1，否则为0
        // base case:
        // dp[0][0] = 0
        // dp[0][1] = 1
        // 状态转移方程:
        // dp[i][i] = true
        // dp[i][i + 1] = s[i] == s[i + 1]
        // dp[i][j] = s[i] == s[j] && dp[i + 1][j - 1]
         dp[0][0] = false;
         dp[0][1] = true;

         for (int i = 0; i < n; ++i) {
             dp[i][i] = true;
         }

         for (int i = 1; i < n; ++i) {
             boolean check = (s.charAt(i - 1) == s.charAt(i));
             dp[i - 1][i] = check;
             if (check) {
                 maxLen = 2;
                 ans = s.substring(i - 1, i - 1 + maxLen);
             }
         }

        for (int i = 1; i < n - 1; ++i) {
            for (int j = i; j < n; ++j) {
                boolean check = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                dp[i][j] = check;
                if (check) {
                    maxLen = j - i + 1;
                    ans = s.substring(i, i + maxLen);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        new lc5().longestPalindrome("abccba");
    }
}
