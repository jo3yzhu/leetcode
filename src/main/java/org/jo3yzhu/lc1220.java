package org.jo3yzhu;


import java.math.BigInteger;

public class lc1220 {

    public static void main(String[] args) {
//        System.out.println(new lc1220().countVowelPermutation(1));
//        System.out.println(new lc1220().countVowelPermutation(2));
//        System.out.println(new lc1220().countVowelPermutation(3));
//        System.out.println(new lc1220().countVowelPermutation(4));
//        System.out.println(new lc1220().countVowelPermutation(5));
//        System.out.println(new lc1220().countVowelPermutation(800));
        for (int i = 0; i < 20000; ++i) {
            System.out.println(new lc1220().countVowelPermutation2(i));
        }
    }



    public int countVowelPermutation(int n) {
        if (n == 1) {
            return 5;
        }
        n--;
        BigInteger[] Na = new BigInteger[n];
        BigInteger[] Ne = new BigInteger[n];
        BigInteger[] Ni = new BigInteger[n];
        BigInteger[] No = new BigInteger[n];
        BigInteger[] Nu = new BigInteger[n];
        Na[0] = new BigInteger("1");
        Ne[0] = new BigInteger("1");
        Ni[0] = new BigInteger("1");
        No[0] = new BigInteger("1");
        Nu[0] = new BigInteger("1");


        for (int i = 1; i < n; ++i) {
            Na[i] = Ne[i - 1].add(Ni[i - 1]).add(Nu[i - 1]);
            Ne[i] = Na[i - 1].add(Ni[i - 1]);
            Ni[i] = Ne[i - 1].add(No[i - 1]);
            No[i] = Ni[i - 1];
            Nu[i] = Ni[i - 1].add(No[i - 1]);
        }

        BigInteger result = Na[n - 1]
                .add(Ne[n - 1]).add(Ne[n - 1])
                .add(Ni[n - 1]).add(Ni[n - 1]).add(Ni[n - 1]).add(Ni[n - 1])
                .add(No[n - 1]).add(No[n - 1])
                .add(Nu[n - 1]);

        return result.mod(new BigInteger("1000000007")).intValue();
    }

    public int countVowelPermutation2(int n) {
        if (n == 1) {
            return 5;
        }
        n--;
        long[] Na = new long[n];
        long[] Ne = new long[n];
        long[] Ni = new long[n];
        long[] No = new long[n];
        long[] Nu = new long[n];
        Na[0] = 1;
        Ne[0] = 1;
        Ni[0] = 1;
        No[0] = 1;
        Nu[0] = 1;

        for (int i = 1; i < n; ++i) {
            Na[i] = (Ne[i - 1] + Ni[i - 1] + Nu[i - 1]) % 1000000007L;
            Ne[i] = (Na[i - 1] + Ni[i - 1]) % 1000000007L;
            Ni[i] = (Ne[i - 1] + No[i - 1]) % 1000000007L;
            No[i] = (Ni[i - 1]) % 1000000007L;
            Nu[i] = (Ni[i - 1] + No[i - 1]) % 1000000007L;
        }

        return (int) ((Na[n - 1] + 2 * Ne[n - 1] + 4 * Ni[n - 1] + 2 * No[n - 1] + Nu[n - 1]) % 1000000007L);
    }
}
