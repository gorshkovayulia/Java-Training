package plates;

import java.util.Arrays;

public class PlateCell {

    private static final char[] LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
            'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public Dimensions dimensions;
    int row, column;

    public PlateCell(String cell, Dimensions dimensions) {
        String[] split = cell.split("(?<=\\D)(?=\\d)");
        this.dimensions = dimensions;
        this.row = new String(LETTERS).indexOf(split[0]);
        this.column = Integer.parseInt(split[1]) - 1;
        if (column < 0) {
            throw new IllegalArgumentException(cell + " cell does not exist!");
        }
        if (row + 1 > dimensions.getNumberOfRows() | column + 1 > dimensions.getNumberOfColumns()) {
            throw new IllegalArgumentException(cell + " cell does not exist in " + dimensions.getSizeOfPlate() + " plate.");
        }
    }

    public PlateCell(int row, int column, Dimensions dimensions) {
        if (row <= 0 | column <= 0) {
            throw new IllegalArgumentException("Row and column cannot be less or equal 0!");
        }
        if (row > dimensions.getNumberOfRows() | column > dimensions.getNumberOfColumns()) {
            throw new IllegalArgumentException("Row and column numbers cannot exceed " + Arrays.toString(dimensions.getArrayOfDimensions()) + " dimensions!");
        }
        this.row = row - 1;
        this.column = column - 1;
        this.dimensions = dimensions;
    }

    public PlateCell(int tecanCellNumber, Dimensions dimensions) {
        if (tecanCellNumber <= 0) {
            throw new IllegalArgumentException("Tecan cell number cannot be less or equal 0!");
        }
        if (tecanCellNumber > dimensions.getSizeOfPlate()) {
            throw new IllegalArgumentException(tecanCellNumber + " cell number is too big for " + Arrays.toString(dimensions.getArrayOfDimensions()) + " dimensions!");
        }
        this.dimensions = dimensions;
        //Row and column are calculated based on cell number.The numbering goes from top to bottom (not left to right).
        this.row = (tecanCellNumber - 1) % dimensions.getNumberOfRows();
        this.column = (tecanCellNumber - 1) / dimensions.getNumberOfRows();
    }

    //Return cell number, e.g. cell number = 16 for "H02" coordinate on 96 plate.
    public int toCellNumber() {
        return column * dimensions.getNumberOfRows() + row + 1;
    }

    //Return human readable coordinate (e.g. A01, C12 etc).
    @Override
    public String toString() {
        char letter = LETTERS[row];
        int number = column + 1;

        if (number < 9) {
            return letter + "0" + number;
        }
        return letter + "" + number;
    }

    //Compare CellNumber and Dimensions for two PlateCell objects.
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PlateCell platecell = (PlateCell) obj;
        return toCellNumber() == platecell.toCellNumber() && dimensions.equals(platecell.dimensions);
    }
}
