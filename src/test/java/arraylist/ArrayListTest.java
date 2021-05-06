package arraylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {

    @Test
    public void possibleToAddMaxInitialCountOfElements() {
        ArrayList<Integer> list = new ArrayList<>();
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
        ArrayList<Integer> list = new ArrayList<>();
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
        list.add(11);
        assertEquals(11, list.getCount());
    }

    @Test
    public void possibleToSetValueAtZeroPosition() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.set(0, 100);
        assertEquals(100, list.getValue(0));
    }

    @Test
    public void possibleToSetValueInTheMiddleOfList() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
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
        ArrayList<Integer> list = new ArrayList<>();
        list.set(0, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void impossibleToSetValueInNotExistingPosition() {
        ArrayList<Integer> list = new ArrayList<>();
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
    public void impossibleToSetValueAtPositionWithNegativeIndex() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.set(10, -1);
    }

    @Test
    public void possibleToRemoveValueFromTheFirstPosition() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.remove(0);
        assertEquals(0, list.getCount());
    }

    @Test
    public void possibleToRemoveValueFromTheMiddlePosition() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertArrayEquals(new Object[] {1, 3}, list.toArray());
    }

    @Test
    public void possibleToRemoveValueFromTheLastPosition() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        assertArrayEquals(new Object[] {1, 2}, list.toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void impossibleToRemoveValueFromEmptyList() {
        ArrayList<Object> list = new ArrayList<>();
        list.remove(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void impossibleToRemoveElementWithNotExistingIndex() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.remove(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void impossibleToRemoveElementWithNegativeIndex() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
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
        list.add(1);
        list.add(2);
        assertEquals(2, list.getCount());
    }

    @Test
    public void possibleToReturnArrayFromArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        assertArrayEquals(new Object[] {1}, list.toArray());
    }

    @Test
    public void possibleToReturnAnEmptyArrayFromArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        assertArrayEquals(new Object[] {}, list.toArray());
    }
}