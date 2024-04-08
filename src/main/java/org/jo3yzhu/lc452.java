package org.jo3yzhu;

import java.util.Arrays;
import java.util.Comparator;

public class lc452 {
    public static void main(String[] args) {
        System.out.println(new lc452().findMinArrowShots(new int[][] {{1,6}, {2,8}, {7,12}, {10,16} }));
        System.out.println(new lc452().findMinArrowShots(new int[][] {{1,2}, {3,4}, {5,6}, {7,8} }));
        System.out.println(new lc452().findMinArrowShots(new int[][] {{1,2}, {2,3}, {3,4}, {4,5} }));
    }

    private int[] joinTwoRange(int[] l, int[] r) {
        if (l == null) {
            return r;
        }

        l[0] = Math.max(l[0], r[0]);
        l[1] = Math.min(l[1], r[1]);
        return l;
    }

    private boolean joinValid(int[] l, int[] r) {
        int min = Math.max(l[0], r[0]);
        int max = Math.min(l[1], r[1]);
        return min <= max;
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int result = 0;
        int[] previous = null;
        for (int[] point : points) {
            if (previous != null) {
                if (!joinValid(previous, point)) {
                    result++;
                    previous = point;
                    continue;
                }
            }
            previous = joinTwoRange(previous, point);
        }
        return result + 1;
    }
}
