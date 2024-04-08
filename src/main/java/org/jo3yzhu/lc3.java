package org.jo3yzhu;

import java.util.HashSet;
import java.util.Set;

public class lc3 {

    public static void main(String[] args) {
        System.out.println(new lc3().lengthOfLongestSubstring("dvdf"));
        System.out.println(new lc3().lengthOfLongestSubstring("vddf"));
        System.out.println(new lc3().lengthOfLongestSubstring("au"));
        System.out.println(new lc3().lengthOfLongestSubstring("abcdddd"));
        System.out.println(new lc3().lengthOfLongestSubstring("dddddddd"));
        System.out.println(new lc3().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new lc3().lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int result = 0;
        Set<Character> window = new HashSet<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (window.contains(c)) {
                result = Math.max(result, right - left);
                while (left < right && window.contains(c)) {
                    char cl = s.charAt(left);
                    window.remove(cl);
                    left++;
                }
            } else {
                window.add(c);
                right++;
            }
        }

        return Math.max(result, right - left);
    }
}
