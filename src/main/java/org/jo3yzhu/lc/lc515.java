package org.jo3yzhu.lc;

import java.util.*;

public class lc515 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private class LeveledTreeNode extends TreeNode {
        int level;
        LeveledTreeNode(TreeNode node, int level) {
            super(node.val, node.left, node.right);
            this.level = level;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Integer[] result = new Integer[2000];
        for (int i = 0; i < 2000; ++i) {
            result[i] = null;
        }


        LinkedList<LeveledTreeNode> queue = new LinkedList<>();
        queue.add(new LeveledTreeNode(root, 0));

        while (!queue.isEmpty()) {
            LeveledTreeNode node = queue.removeLast();
            result[node.level] = result[node.level] == null ? node.val : Math.max(result[node.level], node.val);
            if (node.left != null) {
                queue.add(new LeveledTreeNode(node.left, node.level + 1));
            }

            if (node.right != null) {
                queue.add(new LeveledTreeNode(node.right, node.level + 1));
            }
        }

        List<Integer> resultNew = new ArrayList<>(result.length);
        for (Integer n : result) {
            if (n == null) {
                break;
            }
            resultNew.add(n);
        }

        return resultNew;
    }
}
