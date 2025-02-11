package org.jo3yzhu.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc57 {

    public static void main(String[] args) {
        // some test cases

        // 1. no overlapping case
        // [1,2], [5,6] insert [3,4] = [1,2],[3,4],[5,6]

        // 2. partly overlapping case
        // [1,2], [5,8] insert [4,7] = [1,2], [4,7]

        // 3. fully overlapping case1
        // [1,2], [5,6] insert [4,7] = [1,2], [4,7]

        // 4. fully overlapping case2
        // [1,4], [8,13] insert [3,7]


        // detect overlap interval[1] >= newInterval[0]

//        new lc57().assertResult(new int[][] {{1,2 },{3,5 },{6,7},{8,10},{12,16}}, new int[] {4,8}, new int[][] {{1,2 },{3,10 },{12, 16}});
        new lc57().assertResult(new int[][] {{1,5}}, new int[] {0,1}, new int[][] {{0,5}});
    }

    private void assertResult(int[][] intervals, int[] newInterval, int[][] expected) {
        int[][] actual = insert(intervals, newInterval);

        // 1. ensure every pair in the result is valid
        for (int[] pairs : actual) {
            assert pairs.length == 2;
        }

        for (int[] pairs : expected) {
            assert pairs.length == 2;
        }

        // 2. ensure interval numbers are equal
        assert expected.length == actual.length;

        // 3. after ensuring that they're of the same shape, check each element
        for (int i = 0; i < expected.length; ++i) {
            int[] actualPair = actual[i];
            int[] expectedPair = expected[i];
            assert Arrays.equals(actualPair, expectedPair);
        }
    }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>(intervals.length);

        boolean inserted = false;
        for (int[] currentInterval : intervals) {

            if (inserted) {
                int[] lastInterval = result.get(result.size() - 1);
                if (lastInterval[1] >= currentInterval[0]) {
                    lastInterval[0] = Math.min(lastInterval[0], currentInterval[0]);
                    lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
                } else {
                    result.add(currentInterval);
                }
                continue;
            }

            // definitely no overlap
            if (currentInterval[0] > newInterval[1] && currentInterval[1] > newInterval[0]) {
                result.add(newInterval);
                result.add(currentInterval);
                inserted = true;
                continue;
            }

            // there must be an overlap
            if (currentInterval[1] >= newInterval[0]) {
                currentInterval[0] = Math.min(currentInterval[0], newInterval[0]);
                currentInterval[1] = Math.max(currentInterval[1], newInterval[1]);
                result.add(currentInterval);
                inserted = true;
                continue;
            }

            result.add(currentInterval);
        }

        if (!inserted) {
            result.add(newInterval);
        }

        return result.toArray(new int[][]{});
    }
}
