package datastructures.lists;
import datastructures.interfaces.LinkedList;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements LinkedList<T>{
    private static class Node<T> {

        T data;
        Node<T> next;
        Node<T> prev;
        Node(T data) {
            this.data = data;
        }

    }
    private Node<T> head = new Node<>(null);
    private Node<T> tail = new Node<>(null);
    private int size = 0;


    @Override
    public void addFirst(T t) {

        Node<T> temp = new Node<>(t);
        if(head.next != null) {
        temp.next = head.next;
        head.next.prev = temp;
        }
        head.next = temp;
        size ++;
    }

    @Override
    public void addLast(T t) {
        Node<T> temp = new Node<>(t);
        if (tail.prev != null) {
            temp.prev = tail.prev;
            tail.prev.next = temp;
        } else {
            head.next = temp;
        }
        tail.prev = temp;


        size ++;
    }

    @Override
    public T removeFirst() {
        if(size == 0)throw new NoSuchElementException();
        Node<T> temp = head.next;
        if(temp.next != null){
            head.next = temp.next;
            head.next.prev = null;
        }
        else {
            head.next = null;
            tail.prev = null;
        }
        size--;
        return (T)temp.data;
    }

    @Override
    public T removeLast() {
        if(size == 0)throw new NoSuchElementException();
        Node<T> temp = tail.prev;
        if(temp.prev != null){
            tail.prev = temp.prev;
            tail.prev.next = null;
        }
        else {
            tail.prev = null;
            head.next = null;
        }
        size--;
        return (T)temp.data;
    }

    @Override
    public T getFirst() {
        if(size == 0 ) throw new NoSuchElementException();
        return head.next.data;
    }

    @Override
    public T getLast() {
        if(size == 0 ) throw new NoSuchElementException();
        return tail.prev.data;
    }

    @Override
    public void clear() {
        Node<T> temp = head.next;
        while(temp != null) {
            Node<T> next = temp.next;
            temp.prev = null;
            temp.next = null;
            temp = next;
        }

        head.next = null;
        tail.prev = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        if(index >= size) throw new IndexOutOfBoundsException();
        Node<T> temp;
        temp = head.next;
        for (int i = 0 ; i < index ; i++){
            temp = temp .next;
        }
        return temp.data;

    }

    @Override
    public Object set(int index, Object element) {
        if(index >= size) throw new IndexOutOfBoundsException();
        Node<T> temp;
        temp = head.next;
        for (int i = 0 ; i < index ; i++){
            temp = temp .next;
        }
        temp.data = (T) element;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(Object o) {
        addLast((T)o);
        return true;
    }

    @Override
    public boolean contains(Object o) {
        Node <T> temp = head.next;
        while (temp != null){
            if(temp.data != null && temp.data.equals(o)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> temp = head.next;
        while (temp != null){
            if(temp.data != null && temp.data.equals(o)){
                if(temp.prev != null && temp.next != null){
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                else if(temp.prev != null) {
                    tail.prev = temp.prev;
                    temp.prev.next = null;
                }
                else if(temp.next != null){
                    temp.next.prev = null;
                    head.next = temp.next;
                }
                temp.prev = null;
                temp.next = null;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

}