package hashtable;

/**
 * This class implements a hash table, which maps keys to values.
 * Collision is handled via "Open Addressing" technique where all elements are stored in the hash table itself.
 * Each table entry contains either a record or NULL.
 * When searching for an element, we one by one examine table slots until the desired element is found or
 * it is clear that the element is not in the table.
 */
public class LinearProbingHashTable {
    private Item[] table;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private int size;

    /**
     * Constructs a new hash table with specified size
     * @param size the initial size of the hash table
     * @throws IllegalArgumentException if the specified size is less or equal to zero
     */
    public LinearProbingHashTable(int size) {
        if(size <= 0) {
            throw new IllegalArgumentException("The size of table must be greater than 0!");
        }
        table = new Item[size];
    }

    /**
     * Inserts item into a table.
     * If item with specified key already exists in table or slot has deleted item,
     * the old item will be replaced with the new one.
     * If new item has the same hashcode as one of the existing items but different key,
     * it will be placed into next empty slot.
     * @param key the key
     * @param value the value
     */
    public void put(Object key, Object value) {
        Item item = new Item(key, value);
        int idx = findIdxToInsert(key);
        table[idx] = item;
        size++;
        double loadFactor = ((double)size) / table.length;
        if (loadFactor > DEFAULT_LOAD_FACTOR) {
            rehash();
        }
    }

    /**
     * Removes item from the table and puts "Deleted" item instead of it.
     * @param key the key that needs to be removed
     * @throws IllegalArgumentException if specified key is null
     */
    public void remove(Object key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null!");
        }
        int index = findIdxToInsert(key);
        if(table[index] != null && table[index] != Item.DELETED) {
            table[index] = Item.DELETED;
        }
    }

    /**
     * Returns the value to which the specified key is mapped
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped;
     * otherwise the "null" if item with specified key does not exist or it's deleted item
     */
    public Object get(Object key) {
        if (key == null) {
            return null;
        }
        int hash = findIdxToInsert(key);
        if (table[hash] == null || table[hash] == Item.DELETED) {
            return null;
        } else {
            return table[hash].getValue();
        }
    }

    Item getContent(int index) {
        return table[index];
    }

    private int findIdxToInsert(Object key) {
        int hash = Math.abs(key.hashCode() % table.length);
        while (table[hash] != null && table[hash].getKey() != key && table[hash] != Item.DELETED)
            hash = (hash + 1) % table.length;
        return hash;
    }

    /**
     * Increases the size and internally reorganizes table,
     * in order to accommodate and access its entries more efficiently
     */
    private void rehash() {
        for(Object o: table) {
            if(o == Item.DELETED) {
                o = null;
            }
        }
        Item[] temp = table;
        table = new Item[2 * table.length];
        size = 0;
        for(Item o: temp) {
            if(o != null) {
                Object key = o.getKey();
                Object value = o.getValue();
                put(key, value);
            }
        }
    }
}
