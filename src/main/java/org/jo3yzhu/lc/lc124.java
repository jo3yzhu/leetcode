package org.jo3yzhu.lc;

public class lc124 {

    public static void main(String[] args) {
        TreeNode nn10 = new TreeNode(-10);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        nn10.left = n9;
        nn10.right = n20;
        n20.left = n15;
        n20.right = n7;
        System.out.println(new lc124().maxPathSum(nn10));
        System.out.println(new lc124().maxPathSum(new TreeNode(-2)));
        TreeNode nn2 = new TreeNode(-2);
        TreeNode nn1 = new TreeNode(-1);
        nn2.right = nn1;
        System.out.println(new lc124().maxPathSum(nn2));
    }

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

    private int max(Integer... nums) {
        int result = Integer.MIN_VALUE;
        for (Integer num : nums) {
            if (num == null) {
                continue;
            }

            if (num > result) {
                result = num;
            }
        }
        return result;
    }

    private Integer sum(Integer... nums) {
        Integer result = null;
        for (Integer num : nums) {
            if (num == null) {
                continue;
            }
            if (result == null) {
                result = num;
            } else {
                result += num;
            }
        }
        return result;
    }


    public Integer maxPathSum(TreeNode root) {

        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root.val;
        }

        Integer leftChildSum = maxPathSum(root.left);
        Integer rightChildSum = maxPathSum(root.right);
        Integer rootValue = root.val;

        return max(leftChildSum,
                rightChildSum,
                rootValue,
                sum(leftChildSum, rootValue),
                sum(rightChildSum, rootValue),
                sum(leftChildSum, rightChildSum, rootValue));
    }

}
