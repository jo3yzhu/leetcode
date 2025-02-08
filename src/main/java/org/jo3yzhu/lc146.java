package org.jo3yzhu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.function.BiFunction;

public class lc146 {
    static class LRUCache {

        private LinkedList<Integer> linkedList = new LinkedList<>();
        private HashMap<Integer, Integer> hashMap = new HashMap<>();

        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            hashMap.computeIfPresent(key, (ignore, value) -> {
                linkedList.remove((Integer) key);
                linkedList.addLast(key);
                return value;
            });
            return hashMap.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            Integer prevKey = hashMap.put(key, value);
            if (prevKey == null) {
                linkedList.addLast(key);
                if (linkedList.size() > capacity) {
                    int keyRemoved = linkedList.removeFirst();
                    hashMap.remove(keyRemoved);
                }
            } else {
                linkedList.remove((Integer) key);
                linkedList.addLast(key);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1); // [2] {{2->1}}
        cache.put(1, 1); // [2,1] {{2->1}, {1->1}}
        cache.put(2, 3); // [1,2] {{2->3}, {1->1}}
        cache.put(4, 1); // [2,4] {{2->3},{4->1}}
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(2)); // 3
    }
}
