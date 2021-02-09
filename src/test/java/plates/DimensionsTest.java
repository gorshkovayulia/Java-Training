package plates;

import org.testng.annotations.Test;
import plates.Dimensions;

import static org.testng.Assert.*;

public class DimensionsTest {

    @Test void passZeroValues() {
        String errorMessage = null;
        try {
            Dimensions dimensions = new Dimensions(0, 0);
            System.out.println("Should be exception!");
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
        assertEquals(errorMessage, "Number of rows and number of columns cannot be less or equal 0!");
    }

    @Test void passNegativeValues() {
        String errorMessage = null;
        try {
            Dimensions dimensions = new Dimensions(-7, -1);
            System.out.println("Should be exception!");
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
        assertEquals(errorMessage, "Number of rows and number of columns cannot be less or equal 0!");
    }

    @Test void compareObjectsWithTheSameDimensions() {
        Dimensions dimensions1 = new Dimensions(4, 6);
        Dimensions dimensions2 = new Dimensions(4, 6);
        assertTrue(dimensions1.equals(dimensions2));
    }

    @Test void compareObjectWithItself() {
        Dimensions dimensions = new Dimensions(4, 6);
        assertTrue(dimensions.equals(dimensions));
    }

    @Test void compareObjectsWithDifferentDimensions() {
        Dimensions dimensions1 = new Dimensions(4, 6);
        Dimensions dimensions2 = new Dimensions(8, 12);
        assertFalse(dimensions1.equals(dimensions2));
    }

    @Test void compareDifferentObjects() {
        Dimensions dimensions = new Dimensions(4, 6);
        PlateCell cell1 = new PlateCell(15, dimensions);
        assertFalse(cell1.equals(dimensions));
    }
}