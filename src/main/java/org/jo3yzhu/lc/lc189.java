package org.jo3yzhu.lc;

import java.util.Arrays;

public class lc189 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        new lc189().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
//        new lc189().rotate(nums, 6);
//        System.out.println(Arrays.toString(nums));
//        new lc189().rotate(nums, 7);
//        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }

        k = k % nums.length;
        if (k == 0) {
            return;
        }

        // now k is less than nums.length
        int[] tmp = Arrays.copyOfRange(nums, 0, nums.length);
        // copy tailing k nums to the beginning
        System.arraycopy(tmp, tmp.length - k, nums, 0, k);
        System.arraycopy(tmp, 0, nums, k, tmp.length - k);
    }
}
