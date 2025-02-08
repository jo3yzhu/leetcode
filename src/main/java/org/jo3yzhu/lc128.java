package org.jo3yzhu;

import java.util.PriorityQueue;

public class lc128 {

    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
        }

        Integer prev = null;
        int longestOverall = 0;
        int longest = 0;
        while (!minHeap.isEmpty()) {
            int min = minHeap.poll();
            if (prev == null) {
                prev = min;
                longest++;
                longestOverall = Math.max(longest, longestOverall);
                continue;
            }

            if (min == prev) {
                continue;
            }

            if (min - prev == 1) {
                longest++;
                longestOverall = Math.max(longest, longestOverall);
            } else {
                longest = 1;
            }
            prev = min;
        }

        return longestOverall;
    }

    public static void main(String[] args) {
//        System.out.println(new lc128().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
//        System.out.println(new lc128().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(new lc128().longestConsecutive(new int[]{1, 2, 0, 1}));
    }
    }
