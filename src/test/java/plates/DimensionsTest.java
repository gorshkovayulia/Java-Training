package plates;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DimensionsTest {

    @Test
    void DimensionsWithZeroValuesRaiseIllegalArgumentException() {
        String errorMessage = null;
        try {
            Dimensions dimensions = new Dimensions(0, 0);
            System.out.println("Should be exception!");
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
        assertEquals(errorMessage, "Number of rows and number of columns cannot be less or equal 0!");
    }

    @Test
    void DimensionsWithNegativeValuesRaiseIllegalArgumentException() {
        String errorMessage = null;
        try {
            Dimensions dimensions = new Dimensions(-7, -1);
            System.out.println("Should be exception!");
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
        assertEquals(errorMessage, "Number of rows and number of columns cannot be less or equal 0!");
    }

    @Test
    void TwentyFourthPlateSizeIsReturnedFor4RowsAnd6Columns() {
        Dimensions dimensions = new Dimensions(4, 6);
        assertEquals(dimensions.getSizeOfPlate(), 24);
    }

    @Test
    void ArrayWithTheSameDimensionsIsReturnedFor4RowsAnd6Columns() {
        Dimensions dimensions = new Dimensions(4, 6);
        assertEquals(dimensions.getArrayOfDimensions(), new int[] {4, 6});
    }

    @Test
    void TwoObjectsWithTheSameDimensionsAreEqual() {
        Dimensions dimensions1 = new Dimensions(4, 6);
        Dimensions dimensions2 = new Dimensions(4, 6);
        assertTrue(dimensions1.equals(dimensions2));
    }

    @Test
    void ComparingObjectWithItsSelfLeadsToTrueResult() {
        Dimensions dimensions = new Dimensions(4, 6);
        assertTrue(dimensions.equals(dimensions));
    }

    @Test
    void TwoObjectsWithTheSameNumberOfRowsButDifferentNumberOfColumnsAreNotEqual() {
        Dimensions dimensions1 = new Dimensions(4, 6);
        Dimensions dimensions2 = new Dimensions(4, 12);
        assertFalse(dimensions1.equals(dimensions2));
    }

    @Test
    void TwoObjectsWithDifferentNumberOfRowsButTheSameNumberOfColumnsAreNotEqual() {
        Dimensions dimensions1 = new Dimensions(4, 6);
        Dimensions dimensions2 = new Dimensions(8, 6);
        assertFalse(dimensions1.equals(dimensions2));
    }

    @Test
    void TwoObjectsWithDifferentDimensionsAreNotEqual() {
        Dimensions dimensions1 = new Dimensions(4, 6);
        Dimensions dimensions2 = new Dimensions(8, 12);
        assertFalse(dimensions1.equals(dimensions2));
    }

    @Test
    void TwoDifferentObjectsAreNotEqual() {
        Dimensions dimensions = new Dimensions(4, 6);
        PlateCell cell1 = new PlateCell(4, 6, dimensions);
        assertFalse(cell1.equals(dimensions));
    }

    @Test
    void absenceOfSecondObjectLeadsToFalseResult() {
        Dimensions dimensions = new Dimensions(4, 6);
        assertFalse(dimensions.equals(null));
    }
}