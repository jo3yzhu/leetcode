package org.jo3yzhu.lc;

public class lc53 {

    public int maxSubArray(int[] nums) {
        // dp[i]: the sum of the subarray ends on i-th element
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new lc53().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
