package arraylist;

import java.util.Arrays;

class ArrayList<E> {
    private Object[] array = new Object[10];
    private int size = 0;

/*    Add a value at the end of array.
    If array is full filled, the size of it will be increased.*/
    public void add(E value) {
        if (size == array.length) {
            resize((int) (array.length * 1.5 + 1));
        }
        array[size++] = value;
    }

/*    Set a value at the specified place of array.
    If array is full filled, the size of it will be increased.*/
    public void set(int index, E value) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Such index does not exist! Current count of elements in list is " + size);
        }
        if (size == array.length) {
            resize((int) (array.length * 1.5 + 1));
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }


/*    Remove a value from specified place in array.
    Right part of elements starting from next index in array will be moved to the left in order to fill gaps.*/
    public void remove(int index) {
        if (size == 0) {
            throw new IllegalArgumentException("The list is empty!");
        }
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Such index does not exist! Current count of elements in list is " + size);
        }
        int countMoved = size - index - 1;
        System.arraycopy(array, index + 1, array, index, countMoved);
        array[--size] = null;
    }

    public int getCount() {
        return size;
    }

    public E getValue(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Element cannot be found! Current number of elements is " + size);
        }
        return (E) array[index];
    }

    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    // Re-create an array with new increased length.
    private void resize(int newLength) {
        Object[] newArray = new Object[(int) newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
