package Practic_25_26;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap<K, V> implements HashMapInterface<K, V>, Iterable<V> {
    private final int size = 128;
    private final LinkedList<Node<K, V>>[] map = new LinkedList[size];
    private final ArrayList<V> list = new ArrayList<>();

    @Override
    public void add(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        int index = hashFunction(key);
        if (map[index] == null)
            map[index] = new LinkedList<>();
        if(get(key)!=null)
            remove(key);
        map[index].add(node);
        list.add(value);
    }

    @Override
    public V get(K key) {
        int index = hashFunction(key);
        if (map[index] != null) {
            for (Node<K, V> node : map[index]) {
                if (node.getKey().equals(key))
                    return node.getValue();
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunction(key);
        V value;
        if (map[index] != null) {
            Node<K, V>[] nodes = map[index].toArray(new Node[map[index].size()]);
            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i].getKey().equals(key)) {
                    value = nodes[i].getValue();
                    list.remove(map[index].get(i).getValue());
                    map[index].remove(i);
                    return value;
                }
            }
        }
        return null;
    }

    @Override
    public Iterator<V> iterator() {
        return new CustomIterator(this);
    }

    private int hashFunction(K key) {
        return key.hashCode() % size;
    }

    private class Node<K, V> {
        private final K key;
        private final V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "{" + key +
                    "=" + value +
                    "}";
        }
    }

    private class CustomIterator implements Iterator<V> {
        private int currentIndex = 0;

        public CustomIterator(MyHashMap<K, V> vs) {

        }

        @Override
        public boolean hasNext() {
            return currentIndex < list.toArray().length;
        }

        @Override
        public V next() {
            return list.get(currentIndex++);
        }
    }
}
