package hashtable;

import java.util.ArrayList;

public class HashTable<K, V> {
    private final ArrayList<LinkedListNode<K, V>> array;

    /**
     * Constructs a new hashtable with inserted capacity.
     * All slots are null by default.
     * @param capacity initial capacity of hashtable.
     * @exception IllegalArgumentException if the specified capacity is less or equal zero.
     */
    public HashTable (int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity cannot be less or equal zero!");
        }
        array = new ArrayList<>();
        array.ensureCapacity(capacity);
        for (int i = 0; i < capacity; i++) {
            array.add(null);
        }
    }

    /**
     * Inserts pair in a table.
     * If pair with such key already exists in a slot, the old pair will be replaced with the new one.
     * Even If slot is not empty, new pair will be added to this slot as well.
     * @param key the hashtable key
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
    }

    /**
     * Removes a pair with specified key from the table.
     * @param key the key that needs to be removed.
     * @exception IllegalArgumentException if a pair with specified key does not exist in table.
     */
    public void remove(K key) {
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node == null) {
            throw new IllegalArgumentException("Value with such key was not found!");
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
    }

    /**
     * Returns the value to which the specified key is mapped.
     * @param key the key whose associated value is to be returned.
     * @return the value to which the specified key is mapped or null if no value for specified key.
     * @exception IllegalArgumentException if specified key is null.
     */
    public V getValue(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null!");
        }
        LinkedListNode<K, V> node = getNodeForKey(key);
        return node == null ? null : node.value;
    }

    /**
     * Returns the index in table for specified key.
     * @param key the key that needs to be converted into index.
     * @return index in table.
     * @exception IllegalArgumentException if specified key is null.
     */
    public int getIndexForKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null!");
        }
        return Math.abs(key.hashCode() % array.size());
    }

    /**
     * Returns a string containing all pairs (key and value) from specified index(slot).
     * @param index slot in a table
     * @return a string containing all pairs from specified index(slot) or null if slot is empty.
     * @exception IllegalArgumentException if specified index is less than 0, equals or more than size of array.
     */
    public String printSlot(int index) {
        if(index < 0 || index >= array.size()) {
            throw new IllegalArgumentException("Index cannot be less than 0 or more than size of array!");
        }
        String s = array.get(index) == null ? "null" : array.get(index).printContent();
        return s;
    }

    /**
     * Returns a linkedlistnode where specified key was found.
     * If node contains several pairs, the node where original key matches with specified key will be returned.
     * @param key the key whose associated node is to be returned.
     * @return a node for specified key or null if node is empty.
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
}
