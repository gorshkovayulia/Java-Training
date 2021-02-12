package plates;

import java.util.Objects;

public class PlateCell {

    private static final char[] LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
            'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public Dimensions dimensions;
    String cell;
    int row, column;
    int cellNumber;

    public PlateCell(String cell, Dimensions dimensions) {
        this.cell = cell;
        this.dimensions = dimensions;
    }

    public PlateCell(int row, int column, Dimensions dimensions) {
        this.row = row - 1;
        this.column = column - 1;
        this.dimensions = dimensions;
    }

    public PlateCell(int tecanCellNumber, Dimensions dimensions) {
        this.cellNumber = tecanCellNumber - 1;
        this.dimensions = dimensions;
    }

    public int toCellNumber() {
        if (cell != null) {
            String[] split = cell.split("(?<=\\D)(?=\\d)");
            column = Integer.parseInt(split[1]) - 1;
            row = new String(LETTERS).indexOf(split[0]);
        }
        if (cellNumber != 0) {
            return cellNumber + 1;
        }
        return cellNumber = column * dimensions.numberOfRows + row + 1;
    }

    public int[] toRowAndColumn() {
        if (cell != null) {
            String[] split = cell.split("(?<=\\D)(?=\\d)");
            column = Integer.parseInt(split[1]) - 1;
            row = new String(LETTERS).indexOf(split[0]);
            return new int[]{row, column};
        }
        if (cellNumber != 0) {
            row = cellNumber % dimensions.numberOfRows;
            column = cellNumber / dimensions.numberOfRows;
        }
        return new int[]{row, column};
    }

    @Override
    public String toString() {
        if (cell != null) {
            return cell;
        }
        int[] array = toRowAndColumn();
        char letter = LETTERS[array[0]];
        int number = array[1] + 1;

        if (number < 9) {
            return letter + "0" + number;
        }
        else {
            return letter + "" + number;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PlateCell platecell = (PlateCell) obj;
        return cellNumber == platecell.cellNumber;
    }
}
