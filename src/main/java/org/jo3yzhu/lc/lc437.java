package org.jo3yzhu.lc;


import java.util.*;

public class lc437 {

    public static class TreeNode {
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

    private int result = 0;

    private void dfs(TreeNode root, List<Integer> path, int target) {
        if (root == null)  {
            return;
        }

        List<Long> pathPrefixSum = new ArrayList<>();
        pathPrefixSum.add(0L);
        for (int pathValue : path) {
            pathPrefixSum.add(pathPrefixSum.get(pathPrefixSum.size() - 1) + pathValue);
        }


        long currentPrefixSum = pathPrefixSum.get(pathPrefixSum.size() - 1) + root.val;
        for (long prefixSum : pathPrefixSum) {
            if (currentPrefixSum - prefixSum == target) {
                result++;
            }
        }

        path.add(root.val);
        dfs(root.left, path, target);
        path.remove(path.size() - 1);

        path.add(root.val);
        dfs(root.right, path, target);
        path.remove(path.size() - 1);
    }


    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, new ArrayList<>(), targetSum);
        return result;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(-2);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(11);
        TreeNode n7 = new TreeNode(5);
        TreeNode n8 = new TreeNode(-3);
        TreeNode n9 = new TreeNode(10);
        n9.left = n7;
        n9.right = n8;
        n7.left = n4;
        n7.right = n5;
        n8.right = n6;
        n4.left = n1;
        n4.right = n2;
        n5.left = n3;
        int sum = new lc437().pathSum(n9, 8);
        System.out.println(sum);
    }
}
