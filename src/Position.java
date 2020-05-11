public class Position {
    private int row;
    private int col;

    public Position() {
        this.row = -1;
        this.col = -1;
    }

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int col) {
        this.col = col;
    }

    public void setRowCol(int row, int col) {
        setRow(row);
        setColumn(col);
    }

    public boolean equals(Object other) {
        if (!(other instanceof Position))
            return false;

        Position o = (Position)other;
        return this.getRow() == o.getRow() || this.getColumn() == o.getColumn();
    }
}
