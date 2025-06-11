package org.jo3yzhu.lc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lc179 {

    // 在sort过程中，一定会进行两两比较以决定这两个数的相对顺序，谁起头拼的数字越大，谁就排在前面
    // 因为谁起头大家的长度都一样，所以可以直接用字符串比较
    public String largestNumber(int[] nums) {
        List<String> numsInStr = Arrays.stream(nums).
                mapToObj(String::valueOf)
                .sorted((o1, o2) -> {
                    String s1 = o1 + o2;
                    String s2 = o2 + o1;
                    return -s1.compareTo(s2);
                })
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (String num : numsInStr) {
            sb.append(num);
        }

        String res = sb.toString();
        while (res.charAt(0) == '0' && res.length() > 1) {
            res = res.substring(1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new lc179().largestNumber(new int[]{10, 2}));
        System.out.println(new lc179().largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(new lc179().largestNumber(new int[]{0, 0}));
    }
}
