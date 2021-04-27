package plates;

public class Dimensions {

    private final int numberOfRows, numberOfColumns;

    public Dimensions(int numberOfRows, int numberOfColumns) {
        if (numberOfRows <= 0 | numberOfColumns <= 0) {
            throw new IllegalArgumentException("Number of rows and number of columns cannot be less or equal 0!");
        }
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    //Calculate size of the plate.
    public int getSizeOfPlate() {
        return numberOfRows * numberOfColumns;
    }

    //Return an array for correct displaying error message.
    public int[] getArrayOfDimensions() {
        return new int[] {numberOfRows, numberOfColumns};
    }

    //Compare number of rows and number of columns for two Dimensions objects.
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Dimensions dimensions = (Dimensions) obj;
        return numberOfRows == dimensions.numberOfRows && numberOfColumns == dimensions.numberOfColumns;
    }
}
