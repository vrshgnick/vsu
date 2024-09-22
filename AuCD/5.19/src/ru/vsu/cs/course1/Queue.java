package ru.vsu.cs.course1;

import java.util.ArrayList;
import java.util.List;

class Node {
    String pair;
    int count;
    Node next;

    Node(String pair) {
        this.pair = pair;
        this.count = 1;  // Начальная частота - 1
        this.next = null;
    }
}

public class Queue {
    private Node front, rear;

    Queue() {
        this.front = this.rear = null;
    }

    public void enqueue(String pair) {
        // Если очередь пуста, создаем новый узел
        if (this.rear == null) {
            this.rear = new Node(pair);
            this.front = this.rear;
            return;
        }

        // Если пара уже существует, увеличиваем частоту
        Node current = this.front;
        while (current != null) {
            if (current.pair.equals(pair)) {
                current.count++;
                return;
            }
            current = current.next;
        }

        // Если пара не найдена, добавляем новую пару
        Node temp = new Node(pair);
        this.rear.next = temp;
        this.rear = temp;
    }

    public List<Node> getPairs() {
        List<Node> result = new ArrayList<>();
        Node current = this.front;
        while (current != null) {
            result.add(current);
            current = current.next;
        }
        return result;
    }
}