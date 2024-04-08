package org.jo3yzhu;

import java.util.Arrays;
import java.util.PriorityQueue;

public class lc88 {

    public static void main(String[] args) {
        int[] n1 = new int[] {1, 2, 3, 0, 0, 0};
        int[] n2 = new int[] {2, 5, 6};
        new lc88().merge(n1, 3, n2, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] left = Arrays.copyOfRange(nums1, 0, m);
        int[] right = nums2;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < m; ++i) {
            pq.add(left[i]);
        }
        for (int i = 0; i < n; ++i) {
            pq.add(right[i]);
        }
        int idx = 0;
        while (!pq.isEmpty()) {
            nums1[idx++] = pq.poll();
        }
    }
}
