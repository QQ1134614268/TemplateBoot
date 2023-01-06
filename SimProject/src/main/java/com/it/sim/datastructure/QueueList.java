package com.it.sim.datastructure;

class Node2<E> {
    Node2<E> next = null;
    E data;

    public Node2(E data) {
        this.data = data;
    }
}

public class QueueList<E> {

    private Node2<E> head = null;
    private Node2<E> tail = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void pull(E e) {
        Node2<E> node = new Node2<>(e);
        if (isEmpty()) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public E poll() {
        if (isEmpty())
            return null;
        E data = head.data;
        head = head.next;
        return data;
    }

    public int size() {
        Node2<E> temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public static void main(String[] args) {
        QueueList<String> queue = new QueueList<>();
        queue.pull("a");
        queue.pull("b");

        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}