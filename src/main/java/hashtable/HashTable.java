package hashtable;

import java.util.ArrayList;

/**
 * This class implements a hash table, which maps keys to values.
 * Collision is handled via "Separate Chaining" technique where the main idea is
 * to make each cell of hash table point to a linked list of records that have same hash function value.
 */
public class HashTable<K, V> {
    private ArrayList<LinkedListNode<K, V>> array;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private int initialCapacity;
    private int count;

    /**
     * Constructs a new hash table with specified capacity. All slots are null by default.
     * @param initialCapacity the initial capacity of the hash table
     * @throws IllegalArgumentException if the specified capacity is less or equal zero
     */
    public HashTable(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity cannot be less or equal to zero!");
        }
        this.initialCapacity = initialCapacity;
        array = new ArrayList<>();
        array.ensureCapacity(initialCapacity);
        for (int i = 0; i < initialCapacity; i++) {
            array.add(null);
        }
    }

    /**
     * Inserts pair in a table.
     * If pair with such key already exists in a slot, the old pair will be replaced with the new one.
     * Even If slot is not empty, new pair will be added to this slot as well.
     * @param key   the hashtable key
     * @param value the value
     */
    public void put(K key, V value) {
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node != null) {
            node.value = value; // Update old value with a new.
        }
        node = new LinkedListNode<K, V>(key, value);
        int index = getIndexForKey(key);
        if (array.get(index) != null) {
            node.next = array.get(index);
            node.next.prev = node;
        }
        array.set(index, node);
        count++;
        double loadFactor = ((double)count) / initialCapacity;
        if (loadFactor > DEFAULT_LOAD_FACTOR) {
            rehash();
        }
    }

    /**
     * Removes a pair with specified key from the table
     * @param key the key that needs to be removed
     * @throws IllegalArgumentException if a pair with specified key does not exist in table
     */
    public void remove(K key) {
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node == null) {
            return;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            int hashKey = getIndexForKey(key);
            array.set(hashKey, node.next);
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        count--;
    }

    /**
     * Returns the value to which the specified key is mapped
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped; otherwise the "null" if specified key is null or value with such key does not exist
     */
    public V getValue(K key) {
        if (key == null) {
            return null;
        }
        LinkedListNode<K, V> node = getNodeForKey(key);
        return node == null ? null : node.value;
    }

    /**
     * @param index slot in a table
     * @return a string containing all pairs from specified index(slot) or "null" if slot is empty
     * @throws IllegalArgumentException if specified index is less than 0, equals or more than size of array
     */
    String printSlot(int index) {
        if (index < 0 || index >= array.size()) {
            throw new IllegalArgumentException("Index cannot be less than 0 or more than size of array!");
        }
        return array.get(index) == null ? "null" : array.get(index).printContent();
    }

    int getSize() {
        return array.size();
    }

    /**
     * Returns the index in table for specified key
     * @param key the key that needs to be converted into index
     * @return index in table
     * @throws IllegalArgumentException if specified key is null
     */
    private int getIndexForKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null!");
        }
        return Math.abs(key.hashCode() % initialCapacity);
    }

    /**
     * Returns a linkedlist node where specified key was found.
     * If node contains several pairs, the node where original key matches with specified key will be returned.
     * @param key the key whose associated node is to be returned
     * @return a node for specified key or "null" if node is empty
     */
    private LinkedListNode<K, V> getNodeForKey(K key) {
        int index = getIndexForKey(key);
        LinkedListNode<K, V> current = array.get(index);
        while (current != null) {
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Increases the capacity of and internally reorganizes this hash table,
     * in order to accommodate and access its entries more efficiently
     */
    private void rehash() {
        ArrayList<LinkedListNode<K, V>> temp = array;
        array = new ArrayList<>(2 * initialCapacity);
        for (int i = 0; i < 2 * initialCapacity; i++) {
            array.add(null);
        }
        count = 0;
        initialCapacity *= 2;
        for (LinkedListNode<K, V> node : temp) {
            while (node != null) {
                K key = node.key;
                V value = node.value;
                put(key, value);
                node = node.next;
            }
        }
    }
}