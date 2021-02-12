package plates;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PlatesTest {

    @Test void getCellNumberForStringCoordinate() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell("A02", dimensions);
        assertEquals(cell.toCellNumber(), 9);
    }

    @Test void getCellNumberForRowAndColumn() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell(2, 1, dimensions);
        assertEquals(cell.toCellNumber(), 2);
    }

    @Test void getCellNumberForTecanCellNumber() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell(16, dimensions);
        assertEquals(cell.toCellNumber(), 16);
    }

    @Test void getRowAndColumnForStringCoordinate() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell("A02", dimensions);
        assertEquals(cell.toRowAndColumn(), new int[]{1, 2});
    }

    @Test void getRowAndColumnForRowAndColumn() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell(1, 2, dimensions);
        assertEquals(cell.toRowAndColumn(),new int[]{1, 2});
    }

    @Test void getRowAndColumnForTecanCellNumber() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell(16, dimensions);
        assertEquals(cell.toRowAndColumn(),new int[]{8, 2});
    }

    @Test void getStringCoordinateForStringCoordinate() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell("A02", dimensions);
        assertEquals(cell.toString(), "A02");
    }

    @Test void getStringCoordinateForRowAndColumn() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell(2, 1, dimensions);
        assertEquals(cell.toString(), "B01");
    }

    @Test void getStringCoordinateForTecanCellNumber() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell(16, dimensions);
        assertEquals(cell.toString(), "H02");
    }

    @Test void compareObjectsWithTheSameCellNumbers() {
        Dimensions dimensions = new Dimensions(4, 6);
        PlateCell cell1 = new PlateCell(15, dimensions);
        PlateCell cell2 = new PlateCell(15, dimensions);
        assertTrue(cell1.equals(cell2));
    }

    @Test void compareObjectWithItself() {
        Dimensions dimensions = new Dimensions(4, 6);
        PlateCell cell1 = new PlateCell(15, dimensions);
        assertTrue(cell1.equals(cell1));
    }

    @Test void compareObjectsWithDifferentCellNumbers() {
        Dimensions dimensions = new Dimensions(4, 6);
        PlateCell cell1 = new PlateCell(15, dimensions);
        PlateCell cell2 = new PlateCell(20, dimensions);
        assertFalse(cell1.equals(cell2));
    }

    @Test void compareDifferentObjects() {
        Dimensions dimensions = new Dimensions(4, 6);
        PlateCell cell1 = new PlateCell(15, dimensions);
        assertFalse(cell1.equals(dimensions));
    }
}
