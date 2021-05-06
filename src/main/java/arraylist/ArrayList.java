package arraylist;

import java.util.Arrays;

class ArrayList<E> {
    private Object[] array = new Object[10];
    private int size = 0;

    /**
     * Adds a value at the end of list.
     * If list is full filled, the size of it will be increased.
     * @param value element to be appended to the list.
     * */
    public void add(E value) {
        if (size == array.length) {
            resize((int) (array.length * 1.5 + 1));
        }
        array[size++] = value;
    }

    /**
     * Sets a value at the specified position in the list.
     * If list is full filled, the size of it will be increased.
     * @param value element to be appended to the list.
     * @param index particular position in the list.
     * @exception IllegalArgumentException - if specified index is less than 0, equals or more than real size of list.
     * */
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

    /**
     * Removes a value from specified place in list.
     * Right part of elements starting from next index in list will be moved to the left in order to fill gaps.
     * @param index the index of element to be removed.
     * */
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

    /**
     * Returns the number of elements in list.
     * @return the number of elements in list.
     */
    public int getCount() {
        return size;
    }

    /**
     * Returns a value at the specified position in the list.
     * @param index particular position in the list.
     * @return a value that matches specified index.
     * @throws IllegalArgumentException if specified index is less than 0, equals or more than size of list.
     */
    public E getValue(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Element cannot be found! Current number of elements is " + size);
        }
        return (E) array[index];
    }

    /**
     * Returns an array containing all of the elements in the order they were added.
     * @return an array with all elements in list.
     */
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    /**
     * Re-creates the list with new increased length.
     * @param newLength - current length of array * 1.5 + 1.
     */
    private void resize(int newLength) {
        Object[] newArray = new Object[(int) newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
