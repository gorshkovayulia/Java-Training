package plates;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PlateCellTest {

    @Test
    void passingNotExistingStringCellRaisesIllegalArgumentException() {
        Dimensions dimensions = new Dimensions(8, 12);
        String errorMessage = null;
        try {
            PlateCell cell = new PlateCell("A00", dimensions);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
        assertEquals(errorMessage, "A00 cell does not exist!");
    }

    @Test
    void passingA13CellFor96PlateRaisesIllegalArgumentException() {
        Dimensions dimensions = new Dimensions(8, 12);
        String errorMessage = null;
        try {
            PlateCell cell = new PlateCell("A13", dimensions);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
        assertEquals(errorMessage, "A13 cell does not exist in 96 plate.");
    }

    @Test
    void passingI01CellFor96PlateRaisesIllegalArgumentException() {
        Dimensions dimensions = new Dimensions(8, 12);
        String errorMessage = null;
        try {
            PlateCell cell = new PlateCell("I01", dimensions);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
        assertEquals(errorMessage, "I01 cell does not exist in 96 plate.");
    }

    @Test
    void zeroRowIsReturnedForA01CellOn96Plate() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell("A01", dimensions);
        assertEquals(cell.row, 0);
    }

    @Test
    void zeroColumnIsReturnedForA01CellOn96Plate() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell("A01", dimensions);
        assertEquals(cell.column, 0);
    }

    @Test
    void seventhRowIsReturnedForH12CellOn96Plate() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell("H12", dimensions);
        assertEquals(cell.row, 7);
    }

    @Test
    void eleventhColumnIsReturnedForH12CellOn96Plate() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell("H12", dimensions);
        assertEquals(cell.column, 11);
    }

    @Test
    void negativeRowAndColumnRaiseIllegalArgumentException() {
        Dimensions dimensions = new Dimensions(8, 12);
        String errorMessage = null;
        try {
            PlateCell cell = new PlateCell(-5, -3, dimensions);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
        assertEquals(errorMessage, "Row and column cannot be less or equal 0!");
    }

    @Test
    void zeroRowAndColumnRaiseIllegalArgumentException() {
        Dimensions dimensions = new Dimensions(8, 12);
        String errorMessage = null;
        try {
            PlateCell cell = new PlateCell(0, 0, dimensions);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
        assertEquals(errorMessage, "Row and column cannot be less or equal 0!");
    }

    @Test
    void rowAndColumnNumbersExceedingDimensionsRaiseIllegalArgumentException() {
        Dimensions dimensions = new Dimensions(8, 12);
        String errorMessage = null;
        try {
            PlateCell cell = new PlateCell(9, 13, dimensions);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
        assertEquals(errorMessage, "Row and column numbers cannot exceed [8, 12] dimensions!");
    }

    @Test
    void negativeTecanCellNumberRaisesIllegalArgumentException() {
        Dimensions dimensions = new Dimensions(8, 12);
        String errorMessage = null;
        try {
            PlateCell cell = new PlateCell(-5, dimensions);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
        assertEquals(errorMessage, "Tecan cell number cannot be less or equal 0!");
    }

    @Test
    void zeroTecanCellNumberRaisesIllegalArgumentException() {
        Dimensions dimensions = new Dimensions(8, 12);
        String errorMessage = null;
        try {
            PlateCell cell = new PlateCell(0, dimensions);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
        assertEquals(errorMessage, "Tecan cell number cannot be less or equal 0!");
    }

    @Test
    void tecanCellNumberExceedingPlateSizeRaisesIllegalArgumentException() {
        Dimensions dimensions = new Dimensions(8, 12);
        String errorMessage = null;
        try {
            PlateCell cell = new PlateCell(97, dimensions);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
        assertEquals(errorMessage, "97 cell number is too big for [8, 12] dimensions!");
    }

    @Test
    void seventhRowIsReturnedFor96TecanCellNumberOn96Plate() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell(96, dimensions);
        assertEquals(cell.row, 7);
    }

    @Test
    void eleventhColumnIsReturnedFor96TecanCellNumberOn96Plate() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell(96, dimensions);
        assertEquals(cell.column, 11);
    }

    @Test
    void zeroRowIsReturnedFor1TecanCellNumberOn96Plate() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell(1, dimensions);
        assertEquals(cell.row, 0);
    }

    @Test
    void zeroColumnIsReturnedFor1TecanCellNumberOn96Plate() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell(1, dimensions);
        assertEquals(cell.column, 0);
    }

    @Test
    void firstCellNumberIsReturnedForA01cellOn96Plate() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell("A01", dimensions);
        assertEquals(cell.toCellNumber(), 1);
    }

    @Test
    void ninetySixthCellNumberIsReturnedFor8RowAnd12ColumnOn96Plate() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell(8, 12, dimensions);
        assertEquals(cell.toCellNumber(), 96);
    }

    @Test
    void ninetySixthCellNumberIsReturnedFor96TecanCellNimberOn96Plate() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell(96, dimensions);
        assertEquals(cell.toCellNumber(), 96);
    }

    @Test
    void E06cellIsReturnedForE06cellOn96Plate() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell("E06", dimensions);
        assertEquals(cell.toString(), "E06");
    }

    @Test
    void A01cellIsReturnedForFirstRowAndFirstColumnOn96Plate() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell(1, 1, dimensions);
        assertEquals(cell.toString(), "A01");
    }

    @Test
    void H12cellIsReturnedFor96TecanCellNumberOn96Plate() {
        Dimensions dimensions = new Dimensions(8, 12);
        PlateCell cell = new PlateCell(96, dimensions);
        assertEquals(cell.toString(), "H12");
    }

    @Test
    void ObjectsWithTheSameDimensionsAndTheSameCellNumbersAreEqual() {
        Dimensions dimensions = new Dimensions(4, 6);
        PlateCell cell1 = new PlateCell(15, dimensions);
        PlateCell cell2 = new PlateCell(15, dimensions);
        assertTrue(cell1.equals(cell2));
    }

    @Test
    void ComparingObjectWithItsSelfLeadsToTrueResult() {
        Dimensions dimensions = new Dimensions(4, 6);
        PlateCell cell1 = new PlateCell(15, dimensions);
        assertTrue(cell1.equals(cell1));
    }

    @Test
    void ObjectsWithTheSameDimensionsAndDifferentCellNumbersAreNotEqual() {
        Dimensions dimensions = new Dimensions(4, 6);
        PlateCell cell1 = new PlateCell(15, dimensions);
        PlateCell cell2 = new PlateCell(20, dimensions);
        assertFalse(cell1.equals(cell2));
    }

    @Test
    void ObjectsWithDifferentDimensionsAndTheSameCellNumberAreNotEqual() {
        Dimensions dimensions1 = new Dimensions(4, 6);
        Dimensions dimensions2 = new Dimensions(8, 12);
        PlateCell cell1 = new PlateCell(15, dimensions1);
        PlateCell cell2 = new PlateCell(15, dimensions2);
        assertFalse(cell1.equals(cell2));
    }

    @Test
    void ObjectsWithDifferentDimensionsAndDifferentCellNumbersAreNotEqual() {
        Dimensions dimensions1 = new Dimensions(4, 6);
        Dimensions dimensions2 = new Dimensions(8, 12);
        PlateCell cell1 = new PlateCell(10, dimensions1);
        PlateCell cell2 = new PlateCell(15, dimensions2);
        assertFalse(cell1.equals(cell2));
    }

    @Test
    void TwoDifferentObjectsAreNotEqual() {
        Dimensions dimensions = new Dimensions(4, 6);
        PlateCell cell1 = new PlateCell(15, dimensions);
        assertFalse(cell1.equals(dimensions));
    }

    @Test
    void absenceOfSecondObjectLeadsToFalseResult() {
        Dimensions dimensions = new Dimensions(4, 6);
        PlateCell cell1 = new PlateCell(15, dimensions);
        assertFalse(cell1.equals(null));
    }
}

