package datastructures.stacks;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

import java.util.NoSuchElementException;

public class CustomStack<T> implements Queue<T> {
    private CustomLinkedList<T> list;
    private int max;
    public CustomStack(int size) {
        list = new CustomLinkedList<>();
        max = size;
    }

    @Override
    public boolean add(Object t) {
        if(list.size() >= max) throw new IllegalArgumentException();
        list.addFirst((T)t);
        return true;
    }

    @Override
    public boolean offer(Object t) {
        if(list.size() >= max) return false;
        list.addFirst((T)t);
        return true;
    }

    @Override
    public T remove() {
        if(list.isEmpty()) throw new NoSuchElementException();
        T temp = list.getFirst();
        list.removeFirst();
        return temp;
    }

    @Override
    public T poll() {
        if(list.isEmpty()) return null;
        T temp = list.getFirst();
        list.removeFirst();
        return temp;
    }

    @Override
    public T element() {
        if(list.isEmpty()) throw new NoSuchElementException();
        return list.getFirst();
    }

    @Override
    public T peek() {
        if(list.isEmpty()) return null;
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }



}