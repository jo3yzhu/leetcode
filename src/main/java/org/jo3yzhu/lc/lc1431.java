package org.jo3yzhu.lc;

import java.util.ArrayList;
import java.util.List;

public class lc1431 {
    public static void main(String[] args) {

    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int kidWithMostCandies = -1;
        int numMostCandies = -1;
        for (int i = 0; i < candies.length; ++i) {
            if (candies[i] > numMostCandies) {
                numMostCandies = candies[i];
                kidWithMostCandies = i;
            }
        }
        List<Boolean> result = new ArrayList<>(candies.length);
        for (int i = 0; i < candies.length; ++i) {
            if (i == kidWithMostCandies) {
                result.add(true);
                continue;
            }
            if (candies[i] + extraCandies < numMostCandies) {
                result.add(false);
            } else {
                result.add(true);
            }
        }
        return result;
    }
}
