package org.jo3yzhu;

public class lc1071 {
    public static void main(String[] args) {
//        System.out.println(new lc1071().gcdOfStrings("LEET", "CODE"));
//        System.out.println(new lc1071().gcdOfStrings("ABCABC", "ABCABC"));
//        System.out.println(new lc1071().gcdOfStrings("ABABAB", "ABAB"));
//        System.out.println(new lc1071().gcdOfStrings("ABABABAB", "ABAB"));
        System.out.println(new lc1071().gcdOfStrings("ABCABC", "ABC"));
//        System.out.println(new lc1071().gcdOfStrings("LEET", "CODE"));
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty()) {
            return "";
        }

        String pattern = str1.length() > str2.length() ? str2 : str1;

        for (int i = pattern.length(); i >= 1; --i) {
            String sub = pattern.substring(0, i);
            if (checkDivision(str1, str2, sub)) {
                return sub;
            }
        }
        return "";
    }

    private boolean checkDivision(String str1, String str2, String pattern) {
        return checkDivision(str1, pattern) && checkDivision(str2, pattern);
    }

    private boolean checkDivision(String str, String pattern) {
        if (str.length() % pattern.length() != 0) {
            return false;
        }
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) != pattern.charAt(i % pattern.length())) {
                return false;
            }
        }
        return true;
    }
}
