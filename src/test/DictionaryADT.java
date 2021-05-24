package test;

import java.util.Iterator;

public interface DictionaryADT<K,V> {
    public boolean contains(K key);
    public boolean add(K key, V value);
    public boolean delete(K key);
    public V getValue(K key);
    public K getKey(V value);
    public int size();
    public boolean isFull();
    public boolean isEmpty();
    public void clear();
    public Iterator<K> keys();
    public Iterator<V> values();
}
