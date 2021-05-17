package hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashTable2Test {

    @Test
    public void impossibleToCreateHashTableWithNegativeSize() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new HashTable2(-1));
        assertEquals("The size of table must be more than 0!", e.getMessage());
    }

    @Test
    public void impossibleToCreateHashTableWithZeroSize() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new HashTable2(0));
        assertEquals("The size of table must be more than 0!", e.getMessage());
    }

    @Test
    public void possibleToCreateHashTableWithPositiveSize() {
        new HashTable2(1);
    }

    @Test
    public void itemIsUpdatedIfOldAndNewItemsHaveTheSameKey() {
        HashTable2 table = new HashTable2(5);
        table.put("test", 1);
        table.put("test", 2);
        assertEquals(2, table.get("test"));
    }

    @Test
    public void possibleToPutNewItemInsteadOfDeletedItem() {
        HashTable2 table = new HashTable2(5);
        table.put("test", 1);
        table.remove("test");
        table.put("test", 2);
        assertEquals(2, table.get("test"));
    }

    @Test
    public void oldItemIsNotReplacedWithNewIfBothHaveTheSameHash(){
        HashTable2 table = new HashTable2(5);
        table.put("te", 1);
        table.put("tes", 1);
        Item o = table.getContent(2);
        assertEquals("te", o.getKey());
    }

    @Test
    public void sizeIsIncreasedIfCalculatedLoadFactorIsMoreThanDefaultLoadFactor() {
        HashTable2 table = new HashTable2(4);
        table.put("t", 1);
        table.put("te", 2);
        table.put("tes", 3);
        table.put("test", 4);
        assertEquals(8, table.getSize());
    }

    @Test
    public void sizeIsNotIncreasedIfCalculatedLoadFactorEqualsToDefaultLoadFactor() {
        HashTable2 table = new HashTable2(4);
        table.put("t", 1);
        table.put("te", 2);
        table.put("tes", 3);
        assertEquals(4, table.getSize());
    }

    @Test
    public void sizeIsNotIncreasedIfCalculatedLoadFactorIsLessThanDefaultLoadFactor() {
        HashTable2 table = new HashTable2(5);
        table.put("te", 1);
        table.put(10, 10);
        assertEquals(5, table.getSize());
    }

    @Test
    public void impossibleToRemoveElementWithNullKey() {
        HashTable2 table = new HashTable2(5);
        Exception e = assertThrows(IllegalArgumentException.class, () -> table.remove(null));
        assertEquals("Key cannot be null!", e.getMessage());
    }

    @Test
    public void nullIsKeptIfUserTriesToDeleteKeyFromNullSlot() {
        HashTable2 table = new HashTable2(5);
        table.remove(1);
        assertEquals("null", table.printSlot(1));
    }

    @Test
    public void deletedSlotGetDeletedItem() {
        HashTable2 table = new HashTable2(5);
        table.put("test", 1);
        table.remove("test");
        assertEquals("(0,0)", table.printSlot(3));
    }

    @Test
    public void impossibleToDeleteDeletedItem() {
        HashTable2 table = new HashTable2(5);
        table.put("test", 1);
        table.remove("test");
        table.remove("test");
        assertEquals("(0,0)", table.printSlot(3));
    }

    @Test
    public void specifiedItemIsDeletedFromCorrectSlotIfSeveralItemsHaveTheSameInitialHashCode() {
        HashTable2 table = new HashTable2(5);
        table.put("test", 1);
        table.put("testtttt", 2);
        table.remove("testtttt");
        assertEquals("(0,0)", table.printSlot(4));
    }

    @Test
    public void returnsCorrectValueForSpecifiedKey() {
        HashTable2 table = new HashTable2(5);
        table.put("test", 1);
        assertEquals(1, table.get("test"));
    }

    @Test
    public void returnsNullValueForNullKey() {
        HashTable2 table = new HashTable2(5);
        assertNull(table.get(null));
    }

    @Test
    public void returnsZeroForNonExistingKey() {
        HashTable2 table = new HashTable2(5);
        assertEquals(0, table.get(0));
    }

    @Test
    public void returnsZeroForDeletedItem() {
        HashTable2 table = new HashTable2(5);
        table.put("testtttt", 2);
        table.remove("testtttt");
        assertEquals(0, table.get(4));
    }
}