package org.jo3yzhu;


public class lc206 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l = head;
        ListNode m = head.next;
        ListNode r = head.next.next;
        while (r != null) {
            m.next = l;
            l = m;
            m = r;
            r = r.next;
        }
        m.next = l;
        head.next = null;
        return m;
    }
}
