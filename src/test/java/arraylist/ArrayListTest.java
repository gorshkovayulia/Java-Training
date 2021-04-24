package arraylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {

    @Test
    public void possibleToAddStringObject() {
        ArrayList<Object> list = new ArrayList<>();
        list.add("test");
        assertEquals(1, list.getCount());
    }

    @Test
    public void possibleToAddIntegerObject() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        assertEquals(1, list.getCount());
    }

    @Test
    public void possibleToAddNegativeNumber() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(-10);
        assertEquals(1, list.getCount());
    }

    @Test
    public void possibleToAddDecimalNumber() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1.5);
        assertEquals(1, list.getCount());
    }

    @Test
    public void possibleToAddZeroNumber() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(0);
        assertEquals(1, list.getCount());
    }

    @Test
    public void possibleToAddSpecialSymbol() {
        ArrayList<Object> list = new ArrayList<>();
        list.add('!');
        assertEquals(1, list.getCount());
    }

    @Test
    public void possibleToAddNullValue() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(null);
        assertEquals(1, list.getCount());
    }

    @Test
    public void possibleToAddMaxInitialCountOfElements() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        assertEquals(10, list.getCount());
    }

    @Test
    public void possibleToAddMoreThanInitialCountOfElements() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(1);
        list.add(100);
        list.add(10000);
        list.add("test");
        list.add("00");
        list.add("())_&");
        list.add("01test");
        list.add("test0");
        list.add(1.12345);
        assertEquals(11, list.getCount());
    }

    @Test
    public void possibleToSetValueAtZeroPosition() {
        ArrayList<Object> list = new ArrayList<>();
        list.add("test");
        list.add(15);
        list.set(0, 100);
        assertEquals(100, list.getValue(0));
    }

    @Test
    public void possibleToSetValueInTheMiddleOfList() {
        ArrayList<Object> list = new ArrayList<>();
        list.add("test");
        list.add(15);
        list.add("list");
        list.set(1, 100);
        assertEquals(100, list.getValue(1));
    }

    @Test
    public void possibleToSetValueAtTheLastPositionInList() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.set(9, 100);
        assertEquals(100, list.getValue(9));
    }

    @Test(expected = IllegalArgumentException.class)
    public void impossibleToSetValueInEmptyList() {
        ArrayList<Object> list = new ArrayList<>();
        list.set(0, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void impossibleToSetValueInNotExistingPosition() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.set(10, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void impossibleToSetValueInPositionWithNegativeIndex() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.set(10, -1);
    }

    @Test
    public void possibleToRemoveValueFromTheFirstPosition() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(4);
        list.remove(0);
        assertEquals(0, list.getCount());
    }

    @Test
    public void possibleToRemoveValueFromTheMiddlePosition() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(4);
        list.add(10);
        list.add(2500);
        list.remove(1);
        assertEquals(2, list.getCount());
    }

    @Test
    public void possibleToRemoveValueFromTheLastPosition() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(4);
        list.add(10);
        list.add(2500);
        list.remove(2);
        assertEquals(2, list.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void impossibleToRemoveValueFromEmptyList() {
        ArrayList<Object> list = new ArrayList<>();
        list.remove(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void impossibleToRemoveElementWithNotExistingIndex() {
        ArrayList<Object> list = new ArrayList<>();
        list.add("test");
        list.remove(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void impossibleToRemoveElementWithNegativeIndex() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(10);
        list.add("test");
        list.remove(-1);
    }

    @Test
    public void zeroCountIsReturnedForEmptyList() {
        ArrayList<Object> list = new ArrayList<>();
        assertEquals(0, list.getCount());
    }

    @Test
    public void countIsTwoIfSeveralElementsWereAddedToList() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(4);
        list.add("test");
        assertEquals(2, list.getCount());
    }
}