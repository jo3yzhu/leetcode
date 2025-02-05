package org.jo3yzhu;

import java.util.Arrays;

public class lc105 {

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

    private int find(int[] array, int target) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        int rootIndexInOrder = find(inorder, rootValue);
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, rootIndexInOrder);
        int[] rightInOrder = Arrays.copyOfRange(inorder, rootIndexInOrder + 1, inorder.length);
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, 1 + leftInOrder.length);
        int[] rightPreOrder = Arrays.copyOfRange(preorder, 1 + leftPreOrder.length, 1 + leftPreOrder.length + rightInOrder.length);
        TreeNode leftNode = buildTree(leftPreOrder, leftInOrder);
        TreeNode rightNode = buildTree(rightPreOrder, rightInOrder);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new lc105().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
