package org.jo3yzhu.lc;

public class lc1669 {
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


    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head1 = list1;
        ListNode nodeA = null;
        ListNode nodeB = null;
        int counter = 0;
        while (list1.next != null) {
            if (counter + 1 == a) {
                nodeA = list1;
            }
            if (counter == b) {
                nodeB = list1;
                break;
            }
            list1 = list1.next;
            counter++;
        }
        ListNode head2 = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        nodeA.next = head2;
        list2.next = nodeB.next;
        return head1;
    }
}
