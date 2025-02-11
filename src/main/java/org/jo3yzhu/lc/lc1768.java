package org.jo3yzhu.lc;

public class lc1768 {

    public static void main(String[] args) {
        System.out.println(new lc1768().mergeAlternately("abc", "pqr"));
        System.out.println(new lc1768().mergeAlternately("ab", "pqrs"));
        System.out.println(new lc1768().mergeAlternately("abcd", "pq"));
    }

    public String mergeAlternately(String word1, String word2) {
        if (word1.isEmpty()) {
            return word2;
        }
        if (word2.isEmpty()) {
            return word1;
        }

        StringBuilder builder = new StringBuilder(word1.length() + word2.length());
        int idx1 = 0;
        int idx2 = 0;
        boolean flag = true;
        while (idx1 < word1.length() && idx2 < word2.length()) {
            if (flag) {
                builder.append(word1.charAt(idx1++));
            } else {
                builder.append(word2.charAt(idx2++));
            }
            flag = !flag;
        }
        while (idx1 < word1.length()) {
            builder.append(word1.charAt(idx1++));
        }
        while (idx2 < word2.length()) {
            builder.append(word2.charAt(idx2++));
        }
        return builder.toString();
    }
}
