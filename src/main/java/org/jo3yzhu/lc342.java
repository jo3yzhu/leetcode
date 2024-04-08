package org.jo3yzhu;

public class lc342 {
    public boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }

        if (n <= 0 || (n & 3) != 0) {
            return false;
        }

        if (n <= 4) {
            return n == 1 || n == 4;
        }
        return isPowerOfFour(n / 4);
    }
}
