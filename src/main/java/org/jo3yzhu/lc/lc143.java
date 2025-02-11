package org.jo3yzhu.lc;

import java.util.ArrayList;
import java.util.List;

public class lc143 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }

        List<ListNode> nodeList = new ArrayList<>(1024);
        ListNode node = head;
        while (node != null) {
            nodeList.add(node);
            node = node.next;
        }
        node = head;
        int size = nodeList.size();
        int l = 1, r = size - 1;
        while (l <= r) {
            ListNode lnode = nodeList.get(l);
            ListNode rnode = nodeList.get(r);
            node.next = rnode;
            node = rnode;
            node.next = lnode;
            node = lnode;
            l++;
            r--;
        }
        node.next = null;
    }
}
