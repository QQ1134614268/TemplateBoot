package com.it.sim.datastructure;

import java.util.Arrays;

public class QueueArray<E> {
    Object[] queue;
    int size;

    public QueueArray() {
        queue = new Object[10];
    }

    public E poll() {
        if (size == 0)
            return null;
        @SuppressWarnings("unchecked")
        E data = (E) queue[0];
        System.arraycopy(queue, 1, queue, 0, size - 1);
        size--;
        return data;
    }

    private void ensureCapacity(int size) {
        if (size > queue.length) {
            int len = queue.length + 10;
            queue = Arrays.copyOf(queue, len);
        }
    }

    public void pull(E data) {
        ensureCapacity(size + 1);
        queue[size++] = data;
    }

    public static void main(String[] args) {
        QueueArray<Integer> queue = new QueueArray<>();

        for (int i = 0; i < 20; i++) {
            queue.pull(i);
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(queue.poll());
        }
    }
}