package org.jo3yzhu;

public class lc560 {
    public int subarraySum(int[] nums, int k) {
        // (0, i)
        int hits = 0;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int i = prefixSum.length - 1; i >= 0; --i) {
            if (prefixSum[i] == k) {
                hits++;
            }
            for (int j = i; j >= 0; --j) {
                int windowSum = prefixSum[i] - prefixSum[j];
                if (windowSum == k && i != j) {
                    hits++;
                }
            }
        }
        return hits;
    }

    public static void main(String[] args) {
        int hits = new lc560().subarraySum(new int[]{1, 1, 1, 2, 1, 1}, 2);
//          int hits = new lc560().subarraySum(new int[]{-1, -1, 1}, 0);
        System.out.println(hits);
    }
}
