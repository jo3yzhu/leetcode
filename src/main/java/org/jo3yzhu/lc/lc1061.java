package org.jo3yzhu.lc;


import java.util.*;

public class lc1061 {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; ++i) {
//            System.out.println(new lc1061().smallestEquivalentString("parker", "morris", "parser"));
//            System.out.println(new lc1061().smallestEquivalentString("hello", "world", "hold"));
//            System.out.println(new lc1061().smallestEquivalentString("leetcode", "programs", "sourcecode"));
            System.out.println(new lc1061().smallestEquivalentString("cjgbnhojkkmgbmgddajmicdafgklkkdogaebeomcikdbafleihmjmbnmanokfbdkibhabdmdgbencabfikhnccjeceiolggbahnhcjgbnhojkkmgbmgddajmicdafgklkkdogaebeomcikdbafleihmjmbnmanokfbdkibhabdmdgbencabfikhnccjeceiolggbahnhcjgbnhojkkmgbmgddajmicdafgklkkdogaebeomcikdbafleihmjmbnmanokfbdkibhabdmdgbencabfikhnccjeceiolggbahnhcjgbnhojkkmgbmgddajmicdafgklkkdogaebeomcikdbafleihmjmbnmanokfbdkibhabdmdgbencabfikhnccjeceiolggbahnhcjgbnhojkkmgbmgddajmicdafgklkkdogaebeomcikdbafleihmjmbnmanokfbdkibhabdmdgbencabfikhnccjeceiolggbahnhcjgbnhojkkmgbmgddajmicdafgklkkdogaebeomcikdbafleihmjmbnmanokfbdkibhabdmdgbencabfikhnccjeceiolggbahnhcjgbnhojkkmgbmgddajmicdafgklkkdogaebeomcikdbafleihmjmbnmanokfbdkibhabdmdgbencabfikhnccjeceiolggbahnhcjgbnhojkkmgbmgddajmicdafgklkkdogaebeomcikdbafleihmjmbnmanokfbdkibhabdmdgbencabfikhnccjeceiolggbahnhcjgbnhojkkmgbmgddajmicdafgklkkdogaebeomcikdbafleihmjmbnmanokfbdkibhabdmdgbencabfikhnccjeceiolggbahnhcjgbnhojkkmgbmgddajmicdafgklkkdogaebeomcikdbafleihmjmbnmanokfbdkibhabdmdgbencabfikhnccjeceiolggbahnh", "gkcjamihkljkhonhcbableadmjfhofaomcfhgbifmendjhcgbgcejbnddijhbjjfmogjkamngcaodjknebfdnmdblikckcbicdejgkcjamihkljkhonhcbableadmjfhofaomcfhgbifmendjhcgbgcejbnddijhbjjfmogjkamngcaodjknebfdnmdblikckcbicdejgkcjamihkljkhonhcbableadmjfhofaomcfhgbifmendjhcgbgcejbnddijhbjjfmogjkamngcaodjknebfdnmdblikckcbicdejgkcjamihkljkhonhcbableadmjfhofaomcfhgbifmendjhcgbgcejbnddijhbjjfmogjkamngcaodjknebfdnmdblikckcbicdejgkcjamihkljkhonhcbableadmjfhofaomcfhgbifmendjhcgbgcejbnddijhbjjfmogjkamngcaodjknebfdnmdblikckcbicdejgkcjamihkljkhonhcbableadmjfhofaomcfhgbifmendjhcgbgcejbnddijhbjjfmogjkamngcaodjknebfdnmdblikckcbicdejgkcjamihkljkhonhcbableadmjfhofaomcfhgbifmendjhcgbgcejbnddijhbjjfmogjkamngcaodjknebfdnmdblikckcbicdejgkcjamihkljkhonhcbableadmjfhofaomcfhgbifmendjhcgbgcejbnddijhbjjfmogjkamngcaodjknebfdnmdblikckcbicdejgkcjamihkljkhonhcbableadmjfhofaomcfhgbifmendjhcgbgcejbnddijhbjjfmogjkamngcaodjknebfdnmdblikckcbicdejgkcjamihkljkhonhcbableadmjfhofaomcfhgbifmendjhcgbgcejbnddijhbjjfmogjkamngcaodjknebfdnmdblikckcbicdej", "rcomcrewoankfivfgfcfkgeadtnmhagjczisqblyldidsuhfdsooviilaaosgswjbqzhkwfwdgqbnuypegvsqoborpnhtjjaxcpjwtxowutansksxzzydoottmknysmpxyetwhlghwbwqvsasmwjsdcgzgfudhettrasxayqdtjkykeyxvqzuvwtlfnoyvauiilqtfstoeilmzbncnxildnjaaoxezuflkthcgdjneycktavzmsovdtxpxjtcfxfkyvsfxnzrwdnnjcnkplctexlgqzipfvqcxfawzdznhbhtdkhfoirliqdfehsiviiimntnuzyfhnbgxakhozldclhxjzpgzyabxwrrfalqdfeaxtvkkucslhrypsjexjdhbeuuckolfgrvxecuhslcbezuxsoklmqpmobybqausuneushwgrrtafujsljzpprklapncxlwktpitejlujycahvvfvggrzayolskjvaauocfikptwiyntvqejfdxirsbmqqrilnmcopskbtdlozevmbiaxraspymfnyaxgazfxsuoygeqzoccmsxamtpcquxvrpsqzdqxaaouyjnrmqxlsvfwsfnmeqyvvufkvlzhzpsfqojrdntpxekahrknbrjtzmhrasbynxwnzfoishiaqmomkcgfsokrdmxmjyxrmrsaphcxicbfubzbvaeuevvvsidhgtzhxevtjxwiwriqkomltbaenbgxxdvzdcuddixkudbcoplqvyyzrkkkjxlqilowootcapiygayfpqzlhdfemmweynumqocfjlicesvbziglxvuqrimxbntrpaebvcbvdeqkepgnejlfkynpqzfamfylvogkakhgeuqqiegsvjoxjfgoiadlevwnwdwyljvvdzrzgiryhmepannhyfzvzxxbaxnqfrgnpksxomdojqvquwqagomfjubsrkxmnwdwfixbwmegdljzcjtdonufsoweesjlvjqivx"));
        }
    }

    private static class GraphNode {
        private final char value;
        private final GraphNode[] edges;
        GraphNode(char value) {
            this.value = value;
            this.edges = new GraphNode[26];
        }
        void addEdge(GraphNode target) {
            edges[target.value - 'a'] = target;
        }
    }

    private char getSmallestEquivalent(GraphNode root, Queue<GraphNode> queue) {
        char result = root.value;
        boolean[] set = new boolean[26];
        queue.add(root);
        while (!queue.isEmpty()) {
            GraphNode node = queue.poll();
            set[node.value - 'a'] = true;
            result = result > node.value ? node.value : result;
            for (GraphNode adjacent : node.edges) {
                if (adjacent == null) {
                    continue;
                }
                if (set[adjacent.value - 'a']) {
                    continue;
                }
                queue.add(adjacent);
            }
        }
        return result;
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        GraphNode[] nodes = new GraphNode[26];
        for (int i = 0; i < s1.length(); ++i) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            GraphNode n1 = nodes[c1 - 'a'] != null ? nodes[c1 - 'a'] : new GraphNode(c1);
            GraphNode n2 = nodes[c2 - 'a'] != null ? nodes[c2 - 'a'] : new GraphNode(c2);
            n1.addEdge(n2);
            n2.addEdge(n1);
            nodes[c1 - 'a'] = n1;
            nodes[c2 - 'a'] = n2;
        }

        Queue<GraphNode> queue = new ArrayDeque<>(1024);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < baseStr.length(); ++i) {
            char c = baseStr.charAt(i);
            GraphNode node = nodes[c - 'a'];
            if (node == null) {
                stringBuilder.append(c);
            } else {
                char smallestEquivalent = getSmallestEquivalent(node, queue);
                queue.clear();
                stringBuilder.append(smallestEquivalent);
            }
        }

        return stringBuilder.toString();
    }
}
