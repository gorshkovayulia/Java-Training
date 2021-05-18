package hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void impossibleToCreateItemWithNullKey() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Item(null,-1));
        assertEquals("Key and value must not be null!", e.getMessage());
    }

    @Test
    public void impossibleToCreateItemWithNullValue() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Item(1, null));
        assertEquals("Key and value must not be null!", e.getMessage());
    }

    @Test
    public void impossibleToCreateItemWithNullKeyAndValue() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Item(null, null));
        assertEquals("Key and value must not be null!", e.getMessage());
    }
}