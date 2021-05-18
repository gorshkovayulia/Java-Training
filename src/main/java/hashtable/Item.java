package hashtable;

public class Item {
    public static final Item DELETED = new Item(0, 0);
    private final Object key;
    private final Object value;

    Item(Object key, Object value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and value must not be null!");
        }
        this.key = key;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public Object getKey() {
        return key;
    }
}