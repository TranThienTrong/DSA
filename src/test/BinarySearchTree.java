package test;

import java.util.Iterator;
/*Thrown by the nextElement method of an Enumeration to indicate that there are
no more elements in the enumeration.*/
import java.util.NoSuchElementException;

public class BinarySearchTree<K, V> implements DictionaryADT<K, V> {

    private int currentSize;
    private int modCounter;
    private Node<K, V> root;

    public BinarySearchTree() {
        root = null;
        currentSize = 0;
    }

    public void print(Node<K, V> n) {
        if (n != null) {
            n.traverseInOrder(n);
        }
    }

    @Override
    public boolean contains(K key) {
        if (root == null)
            return false;
        Iterator<K> keys = this.keys();
        while (keys.hasNext()) {
            if (keys.next().equals(key))
                return true;
        }
        return false;
    }

    @Override
    public boolean add(K key, V value) {
        if (root == null)
            root = new Node<K, V>(key, value);
        else
            root.insert(key, value, root, null, false);
        currentSize++;
        modCounter++;
        return true;
    }


    @Override
    public boolean delete(K key) {
        if (!this.contains(key)) {
            return false;
        }
        Node<K, V> node = find(key, root, 0);
        Node<K, V> parent = remove(node, root);
        root = parent;
        currentSize--;
        return true;
    }

    private Node<K, V> remove(Node<K, V> delete_node, Node<K, V> start_node) {
        if (start_node == null){
            return start_node;
        }
        if (((Comparable<K>) delete_node.key).compareTo(start_node.key) < 0){
            start_node.leftChild = remove(delete_node, start_node.leftChild);
        }
        else if (((Comparable<K>) delete_node.key).compareTo(start_node.key) > 0){
            start_node.rightChild = remove(delete_node, start_node.rightChild);
        }

        else if (start_node.leftChild != null && start_node.rightChild != null) {
            start_node.setKey(findMin(start_node.rightChild).key);
            start_node.setRightChild(remove(start_node,start_node.rightChild));
        } else
            start_node = (start_node.leftChild != null) ? start_node.leftChild : start_node.rightChild;

        return start_node;
    }

    public Node<K, V> findMin(Node<K, V> t) {
        if (t == null) {
            return null;
        } else if (t.leftChild == null) {
            return t;
        }
        return findMin(t.leftChild);
    }


    @Override
    public V getValue(K key) {
        return find(key, root);
    }
    private V find(K key, Node<K, V> n) {
        if (n == null) {
            return null;
        }
        if (((Comparable<K>) key).compareTo(n.key) < 0) {
            return find(key, n.leftChild);
        } else if (((Comparable<K>) key).compareTo(n.key) > 0) {
            return find(key, n.rightChild);
        } else
            return (V) n.value;
    }

    private Node<K, V> find(K key, Node<K, V> n, int dummy) {
        if (n == null)
            return null;
        if (((Comparable<K>) key).compareTo(n.key) < 0) {
            return find(key, n.leftChild, 0);
        } else if (((Comparable<K>) key).compareTo(n.key) > 0) {
            return find(key, n.rightChild, 0);
        } else
            return n;
    }

    @Override
    public K getKey(V value) {
        Iterator<K> k = keys();
        Iterator<V> v = values();
        while (k.hasNext()) {
            K tempK = k.next();
            V tempV = v.next();
            if (((Comparable<V>) tempV).compareTo(value) == 0)
                return tempK;
        }
        return null;
    }

    /*This returns the number of key/value pairs currently stored in the dictionary.*/
    @Override
    public int size() {
        return currentSize;
    }

    /*This returns true if the dictionary is at max capacity.*/
    @Override
    public boolean isFull() {
        return false;
    }

    /*This returns true if the dictionary is empty.*/
    @Override
    public boolean isEmpty() {
        return this.size() < 1;
    }

    /*This returns the dictionary object to an empty state.*/
    @Override
    public void clear() {
        root = null;
        currentSize = 0;
    }

    @Override
    public Iterator<K> keys() {
        return new IteratingKeys();
    }

    @Override
    public Iterator<V> values() {
        return new IteratingValues();
    }

    /*We create a public class called "HelpingIterateKeys" that will help us iterate
    through our keys.*/
    public class IteratingKeys implements Iterator<K> {
        K[] array;
        private int index;
        private int endIndex;
        public IteratingKeys() {
            array = (K[]) new Object[currentSize];
            OrderedArrayFiller(root);
            index = 0;
            this.endIndex = array.length;
        }
        /*"OrderedArrayFiller" will help us fill in our array in order.*/
        private void OrderedArrayFiller(Node<K, V> n) {
            if (n == null)
                return;
            OrderedArrayFiller(n.leftChild);
            array[index++] = (K) n.key;
            OrderedArrayFiller(n.rightChild);
        }

        /*The java.util.Scanner.hasNext() method Returns true if this scanner has another
        token in its input. This method may block while waiting for input to scan. The
        scanner does not advance past any input.*/
        @Override
        public boolean hasNext() {
            return (index < endIndex);
        }
        @Override
        public K next() {
            if (hasNext() == false) {
                throw new NoSuchElementException();
            }
            return (K) array[index++];
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /*We create a public class called "IteratingValues" to use the iterator to help
    us iterate through our values.*/
    public class IteratingValues implements Iterator<V> {
        V[] array;
        private int index;
        private int endIndex;
        public IteratingValues() {
            array = (V[]) new Object[currentSize];
            OrderedArrayFiller(root);
            index = 0;
            this.endIndex = array.length;
        }

        private void OrderedArrayFiller(Node<K, V> n) {
            if (n == null)
                return;
            OrderedArrayFiller(n.leftChild);
            array[index++] = (V) n.value;
            OrderedArrayFiller(n.rightChild);
        }


        @Override
        public boolean hasNext() {
            return (index < endIndex);
        }

        @Override
        public V next() {
            if (hasNext() == false) {
                throw new NoSuchElementException();
            }
            return (V) array[index++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}