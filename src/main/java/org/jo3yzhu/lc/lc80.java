package org.jo3yzhu.lc;

import java.util.Arrays;

public class lc80 {

    public static void main(String[] args) {
//        int[] nums = new int[] {1,1,1,2,2,3};
//        int[] nums = new int[] {1,1,2,2,3};
//        int[] nums = new int[] {1,1,2,2,3,3,3,3};
        int[] nums = new int[] {0,0,0,0,0,1,2,2,3,3,4,4};
        int result = new lc80().removeDuplicates(nums);
        System.out.println(result);
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            // for example:
            // [0]
            // [0,2]
            // [1,1]
            return nums.length;
        }

        int left = 0;
        int right = 1;
        int elementReplaced = 0;

       while (right < nums.length - elementReplaced) {
           // looking for repeated series
           while (right < nums.length - elementReplaced && nums[left] == nums[right]) {
               right++;
           }

           // check its validity
           if (right - left <= 2) {
               left = right;
               right++;
               continue;
           }

           // detect tailing part of invalid range
           left += 2;
           elementReplaced += (right - left);
           int copyBytes = Math.max(nums.length - right, 0);
           System.arraycopy(nums, right, nums, left, copyBytes);
           right = left + 1;
       }

       return nums.length - elementReplaced;
    }
}
