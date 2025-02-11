package org.jo3yzhu.system;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueue<T> {
    private final LinkedList<T> innerQueue = new LinkedList<>();
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition nonFull = lock.newCondition();
    private final Condition nonEmpty = lock.newCondition();
    private final int maxCapacity;

    public BlockQueue(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void append(T t) throws InterruptedException {
        try {
            lock.lock();
            if (innerQueue.size() == maxCapacity) {
                nonFull.await();
            }
            innerQueue.addLast(t);
            nonEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T pop() throws InterruptedException {
        try {
            lock.lock();
            if (innerQueue.isEmpty()) {
                nonEmpty.await();
            }
            T t = innerQueue.pollFirst();
            nonFull.signal();
            return t;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockQueue<Integer> blockQueue = new BlockQueue<>(4);
        blockQueue.append(10);
        blockQueue.append(10);
    }
}
