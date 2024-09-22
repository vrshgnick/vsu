package ru.vsu.cs.vereschagin.logic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T>{

    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {return current != null;}

        @Override
        public T next() {
            if (!hasNext()) {throw new NoSuchElementException();}
            T data = current.data;
            current = current.next;
            return data;
        }

    }

    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }


    public T head(){ return head.data; }
    public T tail(){ return tail.data; }
    public int size(){ return size; }

    public T get(){
        if(head == null){throw new NoSuchElementException("Очередь пуста");}
        return head.data;
    }

    public T get(int index) {
        if (index < 0 || index >= size) { throw new NoSuchElementException("Элемент вне очереди"); }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }


    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }


    public void remove(){
        if(head == null) return;
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
    }

    public void remove(T data){
        if (head == null) return;

        if (head.data.equals(data)) {
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                size--;
                if (current.next == null) {
                    tail = current;
                }
                return;
            }
            current = current.next;
        }
    }

    public void removeLast(){
        if (head == null) return;

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }

        Node<T> current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = null;
        tail = current;
        size--;
    }

    public LinkedList<Integer> sumPair() {
        LinkedList<Integer> resultList = new LinkedList<>();

        Node<T> current = head;

        while (current != null && current.next != null) {
            int sum = (Integer) current.data + (Integer) current.next.data;
            resultList.add(sum);
            current = current.next.next;
        }

        if (current != null) {
            resultList.add((Integer) current.data);
        }

        return resultList;
    }

    public void sumPairR() {
        Node<T> current = head;

        while (current != null && current.next != null) {
            try{
                int sum = (Integer) current.data + (Integer) current.next.data;
                current.data = (T) Integer.valueOf(sum);
                current.next = current.next.next;
                current = current.next;
                size--;
            }catch (Exception e){
                break;
            }
        }
    }

    public int[] toArr() {
        int[] arr = new int[size];

        Node<T> current = head;
        int index = 0;
        while (current != null) {
            try {
                arr[index] = (Integer) current.data;
                current = current.next;
                index++;
            }catch (Exception e){
                return null;
            }

        }

        return arr;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            s.append(current.data.toString());
            s.append(" ");
            current = current.next;
        }
        return s.toString();
    }
}
