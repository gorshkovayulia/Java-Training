package hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {

    @Test(expected = IllegalArgumentException.class)
    public void impossibleToSetNegativeCapacity() {
        new HashTable(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void impossibleToSetZeroCapacity() {
        new HashTable(0);
    }

    @Test
    public void possibleToSetPositiveCapacity() {
        new HashTable(2);
    }

    @Test
    public void possibleToPutElementInEmptySlot() {
        HashTable table = new HashTable(2);
        table.put("test", 10);
        assertEquals("(test,10)", table.printSlot(0));
    }

    @Test
    public void possibleToPutSeveralElementsIntoTheSameSlot() {
        HashTable table = new HashTable(10);
        table.put("t", 15);
        table.put(6, 20);
        assertEquals("(6,20)->(t,15)", table.printSlot(6));
    }

    @Test
    public void valueIsUpdatedIfOldAndNewObjectsHaveTheSameKeys() {
        HashTable table = new HashTable(10);
        table.put("t", 15);
        table.put("t", 20);
        assertEquals(20, table.getValue("t"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void impossibleToRemoveElementWithNullKey() {
        HashTable table = new HashTable(10);
        table.remove(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void impossibleToRemoveNotExistingElement() {
        HashTable table = new HashTable(10);
        table.remove("test");
    }

    @Test
    public void possibleToDeleteElementHavingPreviousNode() {
        HashTable table = new HashTable(10);
        table.put("t", 15);
        table.put(6, 20);
        table.remove(6);
        assertEquals("(t,15)", table.printSlot(6));
    }

    @Test
    public void possibleToDeleteElementHavingNextNode() {
        HashTable table = new HashTable(10);
        table.put("t", 15);
        table.put(6, 20);
        table.remove("t");
        assertEquals("(6,20)", table.printSlot(6));
    }

    @Test
    public void possibleToDeleteTheOnlyElementInSlot() {
        HashTable table = new HashTable(10);
        table.put("t", 15);
        table.remove("t");
        assertEquals("null", table.printSlot(6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void impossibleToGetValueForNullKey() {
        HashTable table = new HashTable(10);
        table.getValue(null);
    }

    @Test
    public void nullValueIsReturnedForEmptyIndex() {
        HashTable table = new HashTable(10);
        assertEquals(null, table.getValue(1));
    }

    @Test
    public void valueOfTenIsReturnedForTheFirstIndex() {
        HashTable table = new HashTable(10);
        table.put(0, 10);
        table.put(1, 20);
        assertEquals(10, table.getValue(0));
    }

    @Test
    public void valueOfFifteenIsReturnedForTheMiddleIndex() {
        HashTable table = new HashTable(10);
        table.put(0, 20);
        table.put("teeeeeeeeeeee", 15);
        table.put("teee", 20);
        assertEquals(15, table.getValue("teeeeeeeeeeee"));
    }

    @Test
    public void valueOfTwentyIsReturnedForTheLastIndex() {
        HashTable table = new HashTable(10);
        table.put(0, 15);
        table.put("teee", 20);
        assertEquals(20, table.getValue("teee"));
    }

    @Test
    public void possibleToGetIndexForStringKey() {
        HashTable table = new HashTable(10);
        assertEquals(6, table.getIndexForKey("t"));
    }

    @Test
    public void possibleToGetIndexForNumberKey() {
        HashTable table = new HashTable(10);
        assertEquals(6, table.getIndexForKey(6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void impossibleToGetIndexForNullKey() {
        HashTable table = new HashTable(10);
        table.getIndexForKey(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void impossibleToPrintSlotWithNegativeIndex() {
        HashTable table = new HashTable(10);
        table.printSlot(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void impossibleToPrintSlotWithIndexEqualsSizeOfArray() {
        HashTable table = new HashTable(1);
        table.printSlot(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void impossibleToPrintSlotWithIndexMoreThanSizeOfArray() {
        HashTable table = new HashTable(1);
        table.printSlot(2);
    }

    @Test
    public void possibleToPrintNullSlot () {
        HashTable table = new HashTable(1);
        assertEquals("null", table.printSlot(0));
    }

    @Test
    public void possibleToPrintSlotWithOneElement () {
        HashTable table = new HashTable(1);
        table.put(0, 15);
        assertEquals("(0,15)", table.printSlot(0));
    }

    @Test
    public void possibleToPrintSlotWithSeveralElements () {
        HashTable table = new HashTable(1);
        table.put(0, 15);
        table.put("test", 15);
        assertEquals("(test,15)->(0,15)", table.printSlot(0));
    }
}