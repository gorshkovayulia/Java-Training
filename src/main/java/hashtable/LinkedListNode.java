package hashtable;

public class LinkedListNode<K, V> {
    LinkedListNode<K, V> next;
    LinkedListNode<K, V> prev;
    K key;
    V value;

    public LinkedListNode(K k, V v) {
        key = k;
        value = v;
    }

    String printContent() {
        String data = "(" + key + "," + value + ")";
        if (next != null) {
            return data + "->" + next.printContent();
        } else {
            return data;
        }
    }
}
