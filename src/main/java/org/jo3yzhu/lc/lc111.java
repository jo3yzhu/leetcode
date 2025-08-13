package org.jo3yzhu.lc;

import java.util.LinkedList;
import java.util.Queue;

public class lc111 {
    /**
     * Definition for a binary tree node.
     */
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

    class BFSSolution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int depth = 1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; ++i) {
                    TreeNode node = queue.poll();
                    assert node != null;
                    if (node.left == null && node.right == null) {
                        return depth;
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                depth++;
            }
            return -1;
        }
    }

    class DFSSolution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }

            if (root.left == null) {
                return minDepth(root.right) + 1;
            }

            if (root.right == null) {
                return minDepth(root.left) + 1;
            }

            return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
        }
    }
}
