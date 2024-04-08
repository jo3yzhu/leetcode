package org.jo3yzhu;

import java.util.ArrayList;
import java.util.List;

public class lc442 {
    private void setBit(long[] bitmap, int num) {
        long word = bitmap[num / 64];
        bitmap[num / 64] = word | (1L << (num & 63));
    }

    private boolean isBitSet(long[] bitmap, int num) {
        long word = bitmap[num / 64];
        return (word & (1L << (num & 63))) != 0;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int numWords = (100000 + 63) / 64;
        long[] bitmap = new long[numWords];
        for (int num : nums) {
            if (isBitSet(bitmap, num)) {
                result.add(num);
            }
            setBit(bitmap, num);
        }
        return result;
    }
}
