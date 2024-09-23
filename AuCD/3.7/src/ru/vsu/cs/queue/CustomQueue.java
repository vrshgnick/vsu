package ru.vsu.cs.queue;



public class CustomQueue<T> {
    private Node<T> front, rear;
    private int size;

    public CustomQueue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() { return this.front == null; }

    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (this.rear == null) {
            this.front = this.rear = newNode;
        } else {
            this.rear.next = newNode;
            this.rear = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (this.front == null) {
            throw new RuntimeException("пустая очередь");
        }
        T item = this.front.data;
        this.front = this.front.next;
        if (this.front == null) {
            this.rear = null;
        }
        size--;
        return item;
    }

    public int size() { return size; }

    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = front;
        sb.append("[");
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}