package org.jo3yzhu.lc;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class lc23 {
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        Set<Integer> alives = new HashSet<>();
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                alives.add(i);
            }
        }
        if (alives.isEmpty()) {
            return null;
        }

        ListNode head = new ListNode();
        ListNode tail = head;
        while (!alives.isEmpty()) {
            int minIndex = alives.iterator().next();
            ListNode minNode = lists[minIndex];
            for (int i : alives) {
                if (lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minIndex = i;
                }
            }
            if (minNode.next == null) {
                alives.remove(minIndex);
            }
            tail.next = minNode;
            tail = minNode;
            lists[minIndex] = minNode.next;
        }

        return head.next;
    }

    public ListNode mergeKListsBetter(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        int nonEmpty = 0;
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                nonEmpty++;
            }
        }
        if (nonEmpty == 0) {
            return null;
        }

        ListNode head = new ListNode();
        ListNode tail = head;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            minHeap.add(node);
        }

        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null) {
                minHeap.add(minNode.next);
            }
        }

        return head.next;
    }

    public static void main(String[] args) {

    }
}

