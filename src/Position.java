/**
 * Position Class
 *
 * @since 5/11/2020
 * @author Ben Browner
 */

public class Position {
    private int row;
    private int col;

    /**
     * Default Constructor
     */
    public Position() {
        this.row = -1;
        this.col = -1;
    }

    /**
     * Param Consructor
     * @param row the row
     * @param col the column
     */
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Gets the row
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column
     * @return col
     */
    public int getColumn() {
        return col;
    }

    /**
     * Sets row
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Sets column
     * @param col
     */
    public void setColumn(int col) {
        this.col = col;
    }

    /**
     * Checks if two Position objects are equal
     * @param other Position object
     * @return true if both have same row and column, otherwise false
     */
    public boolean equals(Object other) {
        if (!(other instanceof Position))
            return false;

        Position o = (Position)other;
        return this.getRow() == o.getRow() || this.getColumn() == o.getColumn();
    }
}
