package org.jo3yzhu.lc;

import java.util.HashMap;
import java.util.Map;

public class lc1079 {
    public int longestArithSeqLength(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int result = 2;
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                int d = nums[i] - nums[j];
                if (!dp.getOrDefault(j, Map.of()).containsKey(d)) {
                    dp.computeIfAbsent(i, f -> new HashMap<>()).put(d, 2);
                } else {
                    int prev = dp.get(j).get(d);
                    dp.computeIfAbsent(i, f -> new HashMap<>()).put(d, prev + 1);
                    result = Math.max(prev + 1, result);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new lc1079().longestArithSeqLength(new int[]{3, 6, 9, 12}));
        System.out.println(new lc1079().longestArithSeqLength(new int[]{9, 4, 7, 2, 10}));
        System.out.println(new lc1079().longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8}));
    }
}
