package test;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class List<T> implements Iterable<T> {
    public class Node<T> {
        public Node(T obj) {
            this.data=obj;
        }
        public Node<T> next;
        public Node<T> previous;
        public T data;

    }

    private Node<T> head = null;
    private Node<T> tail;
    private int currentSize;


    public void insertFirst(T obj) {
        Node<T> newNode = new Node<T>(obj);
        if (isEmpty()) {
            head = tail = newNode;
        }
        else {
            newNode.next = tail;
            head = newNode;
        }
        currentSize++;
    }

    @SuppressWarnings("unchecked")
    public T find(T object)
    {
        for(T obj : this)
        {
            if (((Comparable<T>) object).compareTo(((T) obj)) == 0)
                return obj;
        }
        return null;
    }

    public void insertLast(T obj) {
        Node<T> newNode = new Node<T>(obj);
        if (isEmpty()) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        currentSize++;
    }

    @SuppressWarnings("unchecked")
    public T remove(T obj) {
        /*We will be traversing the list until we find the object.*/
        Node<T> previous = null, current = head;

        while (current != null && ((Comparable<T>) obj).compareTo(current.data) != 0) {
            previous = current;
            current = current.next;
        }

        if (current == null)
            return null;
        /*If there's only 1 item in the list, we come to this if statement.*/
        if (head == tail)
        {
            head = tail = null;
        }
        else if (previous == null) {
            head = head.next;
        }
        else if (current == tail) {
            previous.next = null;
            tail = previous;
        }
/*If none of the others apply, that means there are two or more nodes and it's in
the middle.*/
        else
        {
            previous.next = current.next;

        }

        currentSize--;
        return current.data;

    }
    /*Returns PQ to an empty state.*/
    public void clear() {
        head = null;
        currentSize = 0;

    }


    /*This is where we do our search.*/
    public Iterator<T> iterator() {
        return new ListIterator();

    }
    /*Returns true if the PQ is empty, otherwise false.*/
    public boolean isEmpty() {
        return this.getCurrentSize() < 1;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    /*We use this for both ordered list and unordered list.*/
    public class ListIterator implements Iterator<T> {

        Node<T> iterPtr;

        public ListIterator() {
            iterPtr = head;
        }

        @Override
        public boolean hasNext() {
            return iterPtr != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T temp = iterPtr.data;
            iterPtr = iterPtr.next;
            return temp;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();

        }

    }

}
