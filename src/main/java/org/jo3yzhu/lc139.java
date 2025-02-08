package org.jo3yzhu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc139 {

    private boolean isPrefixOf(String s, String prefix) {
        if (prefix.length() > s.length()) {
            return false;
        }

        for (int i = 0; i < prefix.length(); ++i) {
            if (s.charAt(i) != prefix.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(String s, List<String>[] buckets) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        int bucketIndex = s.charAt(0) - 'a';
        List<String> bucket = buckets[bucketIndex];
        if (bucket.isEmpty()) {
            return false;
        }
        for (String prefix : bucket) {
            if (!isPrefixOf(s, prefix)) {
                continue;
            }
            String ss = s.substring(prefix.length());
            boolean res = dfs(ss, buckets);
            if (!res) {
                continue;
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        List<String>[] buckets = new List[26];
        for (int i = 0; i < 26; ++i) {
            buckets[i] = new ArrayList<>();
        }

        for (String word : wordDict) {
            int bucketIndex = word.charAt(0) - 'a';
            List<String> bucket = buckets[bucketIndex];
            bucket.add(word);
        }

        return dfs(s, buckets);
    }

    public boolean wordBreakDp(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                dp[i] |= (dp[j] && dict.contains(s.substring(j, i)));
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; ++i) {
            boolean r1 = new lc139().wordBreakDp("catsandog", List.of("cats", "dog", "sand", "san", "cat"));
            boolean r2 = new lc139().wordBreakDp("catsandog", List.of("cats", "dog", "sand", "and", "cat"));
            boolean r3 = new lc139().wordBreakDp("applepie", List.of("pie", "pear", "apple", "peach"));
            boolean r4 = new lc139().wordBreakDp("aaaaaaa", List.of("aaaa", "aaa"));
            boolean r5 = new lc139().wordBreakDp("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"));
        }
    }
}
