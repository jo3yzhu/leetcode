package org.jo3yzhu;

public class lc287 {
    public static void main(String[] args) {
        System.out.println(new lc287().findDuplicate(new int[] {1,3,4,2,2}));
    }

    private void setBit(long[] bitmap, int num) {
        long word = bitmap[num / 64];
        bitmap[num / 64] = word | (1L << (num & 63));
    }

    private boolean isBitSet(long[] bitmap, int num) {
        long word = bitmap[num / 64];
        return (word & (1L << (num & 63))) != 0;
    }

    public int findDuplicate(int[] nums) {
        int numWords = (100000 + 63) / 64;
        long[] bitmap = new long[numWords];
        for (int num : nums) {
            if (isBitSet(bitmap, num)) {
                return num;
            }
            setBit(bitmap, num);
        }
        return -1;
    }
}
