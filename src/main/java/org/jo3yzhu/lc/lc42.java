package org.jo3yzhu.lc;

import java.util.Stack;

public class lc42 {
    public int trap(int[] height) {
        int total = 0;
        Stack<Integer> indexStack = new Stack<>();
        int leftMost = 0;

        for (int i = 0; i < height.length; ++i) {
            int h = height[i];

            // 新柱子高于上一个柱子，计算水
            while (!indexStack.isEmpty() && h > height[indexStack.peek()]) {
                if (leftMost > h) {
                    for (int index : indexStack) {
                        if (height[index] < h) {
                            total += (h - height[index]);
                            height[index] = h;
                            break;
                        }
                    }
                } else {
                    while (!indexStack.isEmpty()) {
                        int index = indexStack.pop();
                        total += (leftMost - height[index]);
                    }
                }
            }

            // 新柱子低于上一个柱子，累计水
            if (indexStack.isEmpty()) {
                leftMost = height[i];
            }
            indexStack.add(i);
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(new lc42().trap(new int[]{1, 0, 2, 0, 1, 0, 3, 0, 3}));
        System.out.println(new lc42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new lc42().trap(new int[]{1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new lc42().trap(new int[]{0, 7, 1, 4, 6}));
        System.out.println(new lc42().trap(new int[]{7, 1, 4, 6}));
    }
}
