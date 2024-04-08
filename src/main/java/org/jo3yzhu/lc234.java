package org.jo3yzhu;

public class lc234 {
    public static class ListNode {
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


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(1);
//        ListNode d = new ListNode(1);
        a.next = b;
        b.next = c;
//        c.next = d;
        c.next = null;
        System.out.println(new lc234().isPalindrome(a));
    }

    private int countNodes(ListNode node) {
        assert node != null;
        int numNodes = 0;
        while (node != null) {
            node = node.next;
            numNodes++;
        }
        return numNodes;
    }

    public boolean isPalindrome(ListNode head) {
        assert head != null;
        if (head.next == null) {
            return true;
        }

        int numNodes = countNodes(head);
        int numNodesNeedToBeReversed = (numNodes - 1) / 2;
        int numNodesReversed = 0;

        // 1. reverse the list until reach the middle node
        ListNode l = head;
        ListNode m = head.next;
        ListNode r = head.next.next;
        while (r != null) {
            m.next = l;
            l = m;
            m = r;
            r = r.next;
            if (++numNodesReversed == numNodesNeedToBeReversed) {
                break;
            }
        }
        head.next = null;

        ListNode symmetryA = (numNodes & 1) == 1 ? l.next : l;
        ListNode symmetryB = m;

        // 2. check symmetry
        while (symmetryA != null && symmetryB != null) {
            if (symmetryA.val != symmetryB.val) {
                return false;
            }
            symmetryA = symmetryA.next;
            symmetryB = symmetryB.next;
        }
        return symmetryA == null && symmetryB == null;
    }
}
