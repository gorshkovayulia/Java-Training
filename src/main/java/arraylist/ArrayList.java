package arraylist;

class ArrayList<E> {
    private Object[] array = new Object[10];
    private int count = 0;

    /*
    Add a value at the end of array.
    If array is full filled, the size of it will be increased.
     */
    public void add(E value) {
        if (count == array.length) {
            resize(array.length * 1.5 + 1);
        }
        array[count++] = value;
    }

    /*
    Set a value at the specified place of array.
    If array is full filled, the size of it will be increased.
     */
    public void set(int index, E value) {
        if (index >= count || index < 0) {
            throw new IllegalArgumentException("Such index does not exist! Current count of elements in list is " + count);
        }
        if (count == array.length) {
            resize(array.length * 1.5 + 1);
        }
        System.arraycopy(array, index, array, index + 1, count - index);
        array[index] = value;
        count++;
    }

    /*
    Remove a value from specified place in array.
    Right part of elements starting from next index in array will be moved to the left in order to fill gaps.
    */
    public void remove(int index) {
        if (count == 0) {
            throw new IllegalArgumentException("The list is empty!");
        }
        if (index >= count || index < 0) {
            throw new IllegalArgumentException("Such index does not exist! Current count of elements in list is " + count);
        }
        int countMoved = count - index - 1;
        System.arraycopy(array, index + 1, array, index, countMoved);
        array[--count] = null;
    }

    public int getCount() {
        return count;
    }

    public E getValue(int index) {
        if (index >= count || index < 0) {
            throw new IllegalArgumentException("Element cannot be found! Current number of elements is " + count);
        }
        return (E) array[index];
    }

    /*
    Re-create an array with new increased length.
     */
    private void resize(double newLength) {
        Object[] newArray = new Object[(int) newLength];
        System.arraycopy(array, 0, newArray, 0, count);
        array = newArray;
    }
}
