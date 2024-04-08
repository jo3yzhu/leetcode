package org.jo3yzhu;

import java.util.*;

public class lc127 {

    private static class Node {
        String word;
        int level;
        Node(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        System.out.println(new lc127().ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log","cog")));
        System.out.println(new lc127().ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log")));
        System.out.println(new lc127().ladderLength("hot", "cog", List.of("hot","dot","dog","lot","log","cog")));
    }

    private boolean diffByOneCharacter(String source, String target) {
        assert source.length() == target.length();
        int diffCount = 0;
        for (int i = 0; i < source.length(); ++i) {
            if (source.charAt(i) != target.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }

    private List<String> getTransforms(String word, List<String> dict) {
        List<String> result = new ArrayList<>();
        for (String step : dict) {
            if (diffByOneCharacter(word, step)) {
                result.add(step);
            }
        }
        return result;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> transformSet = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(beginWord, 1));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            List<String> transforms = getTransforms(node.word, wordList);
            for (String transform : transforms) {
                if (transform.equals(endWord)) {
                    return node.level + 1;
                }
                if (transformSet.contains(transform)) {
                    continue;
                }
                transformSet.add(transform);
                queue.add(new Node(transform, node.level + 1));
            }
        }
        return 0;
    }
}
