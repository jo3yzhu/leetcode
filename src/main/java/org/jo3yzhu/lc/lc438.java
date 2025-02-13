package org.jo3yzhu.lc;

import java.util.*;

public class lc438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return List.of();
        }

        List<Integer> result = new ArrayList<>();

        int[] candidates = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            candidates[p.charAt(i) - 'a']++;
        }

        int[] window = new int[26];
        int l = 0, r = 0;
        while (r < s.length()) {
            while (r - l < p.length() && r < s.length()) {
                window[s.charAt(r) - 'a']++;
                r++;
            }
            // now, r - l == candidates.size()
            if (Arrays.equals(candidates, window)) {
                result.add(l);
            }

            window[s.charAt(l) - 'a']--;
            l++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new lc438().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new lc438().findAnagrams("abab", "ab"));
        System.out.println(new lc438().findAnagrams("abab", "abab"));
    }
}
