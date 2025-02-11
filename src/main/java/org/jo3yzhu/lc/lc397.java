package org.jo3yzhu.lc;

import java.util.ArrayDeque;
import java.util.Queue;

public class lc397 {
    public static void main(String[] args) {
        for (int i = 1; i < 1024; ++i) {
            System.out.println(new lc397().integerReplacement(i));
        }
    }

    static class Node {
        int n;
        int level;

        Node(int n, int level) {
            this.n = n;
            this.level = level;
        }
    }

    int integerReplacement(int n) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(n, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.n == 1) {
                return node.level;
            }

            if ((node.n & 1) != 0) {
                queue.add(new Node(node.n + 1, node.level + 1));
                queue.add(new Node(node.n - 1, node.level + 1));
            } else {
                queue.add(new Node(node.n / 2, node.level + 1));
            }
        }
        return -1;
    }
}
