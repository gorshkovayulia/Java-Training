package hashtable;

public class HashTable2 {
    private Item[] table;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private int count;

    public HashTable2(int size) {
        if(size <= 0) {
            throw new IllegalArgumentException("The size of table must be more than 0!");
        }
        table = new Item[size];
        for (int i = 0; i < size; i++) {
            table[i] = null;
        }
    }

    public void put(Object key, Object value) {
        Item item = new Item(key, value);
        int idx = findIdxToInsert(key);
        table[idx] = item;
        count++;
        double loadFactor = ((double)count) / table.length;
        if (loadFactor > DEFAULT_LOAD_FACTOR) {
            rehash();
        }
    }

    public void remove(Object key) {
        int hash = findIdxToInsert(key);
        if(table[hash] != null && table[hash] != Item.DELETED) {
            table[hash] = Item.DELETED;
        }
    }

    public Object get(Object key) {
        if (key == null) {
            return null;
        }
        int hash = findIdxToInsert(key);
        if (table[hash] == null || table[hash] == Item.DELETED) {
            return 0;
        } else {
            return table[hash].getValue();
        }
    }

    int getSize() {
        return table.length;
    }

    Item getContent(int index) {
        return table[index];
    }

    String printSlot(int index) {
        return table[index] == null ? "null" : table[index].printContent();
    }

    private int findIdxToInsert(Object key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null!");
        }
        int hash = Math.abs(key.hashCode() % table.length);
        while (table[hash] != null && table[hash].getKey() != key && table[hash] != Item.DELETED)
            hash = (hash + 1) % table.length;
        return hash;
    }

    private void rehash() {
        for(Object o: table) {
            if(o == Item.DELETED) {
                o = null;
            }
        }
        Item[] temp = table;
        table = new Item[2 * table.length];
        for (int i = 0; i < 2 * temp.length; i++) {
            table[i] = null;
        }
        count = 0;
        for(Item o: temp) {
            if(o != null) {
                Object key = o.getKey();
                Object value = o.getValue();
                put(key, value);
            }
        }
    }
}
