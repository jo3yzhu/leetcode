package org.jo3yzhu.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {

    class Node {
        public String key;
        public Node next;
        public Node prev;

        public Integer data;

        Node() {
        }

        Node(String key, Integer data) {
            this.key = key;
            this.data = data;
        }
    }

    private Node head;

    private Node tail;

    private final Map<String, Node> map = new HashMap<>();

    private final int maxSize;

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public Integer get(String key) {
        Node node = map.get(key);
        if (node == null) {
            return null;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head;
        head = node;
        return node.data;
    }

    public void put(String key, int value) {
        if (map.containsKey(key)) {
            map.get(key).data = value;
            get(key);
            return;
        }

        // h <-> v <-> t
        if (map.size() > maxSize) {
            assert tail.next == null;
            assert tail.prev != null;
            Node victim = tail.prev;
            map.remove(victim.key);
            victim.prev.next = tail;
        }

        Node node = new Node(key, value);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        map.put(key, node);
    }

    void printList() {
        System.out.println("-------");
        Node node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    void printListReverse() {
        System.out.println("-------");
        Node node = tail;
        while (node != null) {
            System.out.println(node.data);
            node = node.prev;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put("1", 1);
        cache.put("2", 2);
        cache.put("3", 3);
        cache.put("4", 4);

        // assert 1
        Integer data1 = cache.get("1");
        assert data1 == null;

        // assert 2
        cache.get("2");
        cache.put("5", 5);
        Integer data3 = cache.get("3");
        Integer data5 = cache.get("5");
        assert data3 == null;
        assert data5 == 5;
    }
}
