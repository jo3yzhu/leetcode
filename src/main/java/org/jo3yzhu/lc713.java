package org.jo3yzhu;

public class lc713 {
    public static void main(String[] args) {

    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product = product * nums[j];
                if (product < k) {
                    result++;
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
