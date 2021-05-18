package hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinearProbingHashTableTest {

    @Test
    public void impossibleToCreateHashTableWithNegativeSize() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new LinearProbingHashTable(-1));
        assertEquals("The size of table must be greater than 0!", e.getMessage());
    }

    @Test
    public void impossibleToCreateHashTableWithZeroSize() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new LinearProbingHashTable(0));
        assertEquals("The size of table must be greater than 0!", e.getMessage());
    }

    @Test
    public void possibleToCreateHashTableWithPositiveSize() {
        new LinearProbingHashTable(1);
    }

    @Test
    public void possibleToPutItemIntoEmptySlot() {
        LinearProbingHashTable table = new LinearProbingHashTable(5);
        table.put("test", 1);
        Item o = table.getContent(3);
        assertEquals(1, o.getValue());
    }

    @Test
    public void oldItemIsUpdatedIfNewItemHasTheSameKey() {
        LinearProbingHashTable table = new LinearProbingHashTable(5);
        table.put("test", 1);
        table.put("test", 2);
        Item o = table.getContent(3);
        assertEquals(2, o.getValue());
    }

    @Test
    public void possibleToPutNewItemInsteadOfDeletedItem() {
        LinearProbingHashTable table = new LinearProbingHashTable(5);
        table.put("test", 1);
        table.remove("test");
        table.put("test", 2);
        Item o = table.getContent(3);
        assertEquals(2, o.getValue());
    }

    @Test
    public void oldItemIsNotReplacedWithNewItemIfBothHaveTheSameHash(){
        LinearProbingHashTable table = new LinearProbingHashTable(5);
        table.put("te", 1);
        table.put("tes", 1);
        Item o = table.getContent(2);
        assertEquals("te", o.getKey());
    }

    @Test
    public void possibleToPutNewItemEvenIfTableHasAlreadyFullFilled (){
        LinearProbingHashTable table = new LinearProbingHashTable(5);
        table.put("tesssssss", 0);
        table.put("t", 1);
        table.put("te", 2);
        table.put("test", 3);
        table.put("testt", 4);
        table.put("tessss", 5);
        Item o = table.getContent(9);
        assertEquals(5, o.getValue());
    }

    @Test
    public void impossibleToRemoveItemWithNullKey() {
        LinearProbingHashTable table = new LinearProbingHashTable(5);
        Exception e = assertThrows(IllegalArgumentException.class, () -> table.remove(null));
        assertEquals("Key cannot be null!", e.getMessage());
    }

    @Test
    public void nullIsKeptIfUserTriesToRemoveItemFromNullSlot() {
        LinearProbingHashTable table = new LinearProbingHashTable(5);
        table.remove(1);
        Item o = table.getContent(1);
        assertNull(o);
    }

    @Test
    public void impossibleToRemoveDeletedItem() {
        LinearProbingHashTable table = new LinearProbingHashTable(5);
        table.put("test", 1);
        table.remove("test");
        table.remove("test");
        Item o = table.getContent(3);
        assertEquals(0, o.getValue());
    }

    @Test
    public void slotGetDeletedItemAfterRemovingOrdinaryItem() {
        LinearProbingHashTable table = new LinearProbingHashTable(5);
        table.put("test", 1);
        table.remove("test");
        Item o = table.getContent(3);
        assertEquals(0, o.getValue());
    }

    @Test
    public void specifiedItemIsDeletedEvenIfSeveralItemsHaveTheSameHashCode() {
        LinearProbingHashTable table = new LinearProbingHashTable(5);
        table.put("test", 1);
        table.put("testtttt", 2);
        table.remove("testtttt");
        Item o = table.getContent(4);
        assertEquals(0, o.getValue());
    }
    @Test
    public void returnsNullForNullKey() {
        LinearProbingHashTable table = new LinearProbingHashTable(5);
        assertNull(table.get(null));
    }

    @Test
    public void returnsNullForNonExistingItem() {
        LinearProbingHashTable table = new LinearProbingHashTable(5);
        assertNull(table.get(0));
    }

    @Test
    public void returnsNullForDeletedItem() {
        LinearProbingHashTable table = new LinearProbingHashTable(5);
        table.put("testtttt", 2);
        table.remove("testtttt");
        assertNull(table.get(4));
    }

    @Test
    public void returnsCorrectValueForSpecifiedKey() {
        LinearProbingHashTable table = new LinearProbingHashTable(5);
        table.put("test", 1);
        assertEquals(1, table.get("test"));
    }

    @Test
    public void returnsCorrectItemEvenIfSeveralItemsHaveTheSameHashCode() {
        LinearProbingHashTable table = new LinearProbingHashTable(5);
        table.put("test", 1);
        table.put("testtttt", 2);
        assertEquals(2, table.get("testtttt"));
    }
}