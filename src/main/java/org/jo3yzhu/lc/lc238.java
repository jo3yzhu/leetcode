package org.jo3yzhu.lc;

import java.util.Arrays;

public class lc238 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4};
//        int[] nums = new int[] {1,2,3,4,5};
//        int[] nums = new int[] {1,2,3,4,5};
//        int[] nums = new int[] {1,2,3,4,5};
        System.out.println(Arrays.toString(new lc238().productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        // prefixProduct[i] = nums[0] * nums[1] * ... * nums[i - 1]
        // prefixProduct[0] = 1
        // prefixProduct[1] = nums[0]
        // prefixProduct[2] = nums[0] * nums[1]
        int[] prefixProduct = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) {
                prefixProduct[i] = 1;
            } else if (i == 1) {
                prefixProduct[i] = nums[0];
            } else {
                prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
            }
        }

        // suffixProduct[i] = nums[i + 1] * nums[i + 2] * ... * nums[nums.length - 1]
        // suffixProduct[0] = nums[1] * nums[2] * ... * nums[nums.length - 1]
        // suffixProduct[1] = nums[2] * nums[3] * ... * nums[nums.length - 1]
        // suffixProduct[nums.length - 2] = nums[nums.length - 1]
        // suffixProduct[nums.length - 1] = 1
        int[] suffixProduct = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; --i) {
            if (i == nums.length - 1) {
                suffixProduct[i] = 1;
            } else if (i == nums.length - 2) {
                suffixProduct[i] = nums[nums.length - 1];
            } else {
                suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
            }
        }

        // result[i] = prefixProduct[i] * suffixProduct[i]
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = suffixProduct[i] * prefixProduct[i];
        }
        return nums;
    }

    public int[] productExceptSelfRecursiveAndTLE(int[] nums) {
        int[] results = new int[nums.length];
        Arrays.fill(results, 1);
        dfs(nums, results, 1, 1, nums.length, 0, true, 0);
        return results;
    }

    void dfs(int[] nums, int[] results, int product, int currentDepth, int maxDepth, int i, boolean fromLeftBranch, int index) {
        // quit recursive function
        if (currentDepth == maxDepth) {
            results[index] = product;
            return;
        }

        // go right
        dfs(nums, results, product * nums[i + 1], currentDepth + 1, maxDepth, i + 1, false, index);
        // go left
        if (fromLeftBranch) {
            dfs(nums, results, product * nums[i], currentDepth + 1, maxDepth, i + 1, true, index + 1);
        }
    }
}
