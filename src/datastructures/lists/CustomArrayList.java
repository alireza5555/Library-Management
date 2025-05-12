package datastructures.lists;

import datastructures.interfaces.List;

import java.util.Arrays;

public class CustomArrayList<T> implements List<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public CustomArrayList() {
        elements = new Object[INITIAL_CAPACITY];
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    @Override
    public T get(int index) {
        if(index >= size){
            throw new IndexOutOfBoundsException();
        }

        return (T) elements[index];
    }

    @Override
    public T set(int index, T element) {
        T temp = elements[index];
        elements[index] = element;
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0) return true;
        return false;
    }

    @Override
    public boolean add(Object o) {
       ensureCapacity();
       if(o == null) throw new NullPointerException();
       elements[size] = o;
       return true;
    }

    @Override
    public boolean contains(Object o) {
        if(o == null) throw new NullPointerException();
        for(Object temp : elements){
            if(temp == o){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if(o == null)throw new NullPointerException();

        boolean flag = false;
        for(int i = 0 ; i < size ; i++){
            if(elements[i] == o){
                if(i+1 == size){
                    size--;
                    return true;
                }
                flag = true;
            }

            if(flag && i+1 != size){
                elements[i] = elements[i+1];
            }

        }
        if(flag) {
            size--;
            return true;
        }
        return false;
    }

}
