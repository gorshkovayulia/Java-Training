package plates;

public class Dimensions {

    int numberOfRows, numberOfColumns;

    public Dimensions(int numberOfRows, int numberOfColumns) {
        if (numberOfRows <= 0 || numberOfColumns <= 0) {
            throw new IllegalArgumentException("Number of rows and number of columns cannot be less or equal 0!");
        }
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Dimensions dimensions = (Dimensions) obj;
        return numberOfRows * numberOfColumns == dimensions.numberOfRows * dimensions.numberOfColumns;
    }
}
