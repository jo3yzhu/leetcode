package org.jo3yzhu;

public class lc39 {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            char ci = s.charAt(i);
            char cj = t.charAt(j);
            if (ci == cj) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == s.length();
    }
}
