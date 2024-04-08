package org.jo3yzhu;

import java.util.HashMap;
import java.util.Map;

public class lc525 {

    public static void main(String[] args) {
        System.out.println(new lc525().findMaxLength(new int[] {0, 1}));
        System.out.println(new lc525().findMaxLength(new int[] {0, 1, 1}));
        System.out.println(new lc525().findMaxLength(new int[] {0, 1, 0}));
        System.out.println(new lc525().findMaxLength(new int[] {1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1}));
        System.out.println(new lc525().findMaxLength(new int[] {0,0,1,0,0,0,1,1}));
    }

    public int findMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        Map<Integer, Integer> prefixFirstAppearance = new HashMap<>();
        prefixFirstAppearance.put(0, -1);

        int result = 0;
        int prefixSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i] == 1 ? 1 : -1;
            prefixFirstAppearance.putIfAbsent(prefixSum, i);
            Integer firstAppearance = prefixFirstAppearance.get(prefixSum);
            if (firstAppearance != null)
            result = Math.max(result, i - firstAppearance);
        }

        return result;
    }

    public int findMaxLengthDeprecated(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        Map<Integer, Integer> prefixFirstAppearance = new HashMap<>();
        prefixFirstAppearance.put(0, -1);
        Map<Integer, Integer> prefixLastAppearance = new HashMap<>();
        int result = 0;
        int prefixSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i] == 1 ? 1 : -1;
            prefixLastAppearance.put(prefixSum, i);
            if (!prefixFirstAppearance.containsKey(prefixSum)) {
                prefixFirstAppearance.put(prefixSum, i);
            }
        }

        for (Map.Entry<Integer, Integer> entry : prefixLastAppearance.entrySet()) {
            int prefix = entry.getKey();
            int lastAppearance = entry.getValue();
            Integer firstAppearance = prefixFirstAppearance.get(prefix);
            if (firstAppearance != null) {
                result = Math.max(result, lastAppearance - firstAppearance);
            }
        }

        return result;
    }
}
