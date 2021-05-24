package test;

public class Node<K, V> {
    protected K key;
    protected V value;
    protected Node<K, V> leftChild;
    protected Node<K, V> rightChild;

    public Node(K k, V v){
        key = k;
        value = v;
        leftChild = rightChild = null;}


    protected void insert(K k, V v, Node<K, V> node, Node<K, V> parent, boolean wasLeft) {
        if (node == null){
            if(wasLeft)
                parent.leftChild = new Node<K, V>(k, v);
            else
                parent.rightChild = new Node<K, V>(k, v);
        }
        else if (((Comparable<K>) k).compareTo((K) node.key) < 0){
            insert(k, v, node.leftChild, node, true);
        }
        else
            insert(k, v, node.rightChild, node, false);
    }
    protected void traverseInOrder(Node<K, V> n) {
        if(n.leftChild!=null) {
            traverseInOrder(n.leftChild);
        }
        System.out.println(n);
        if (n.rightChild != null) {
            traverseInOrder(n.rightChild);
        }
    }



    /*Getter - Setter*/
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K, V> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<K, V> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<K, V> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<K, V> rightChild) {
        this.rightChild = rightChild;
    }
}
