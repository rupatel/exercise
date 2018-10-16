package com.apple.interview.exercise.chess.search.cell;

import java.util.Objects;

public class Cell {
    private int row;
    private int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return getRow() == cell.getRow() &&
                getCol() == cell.getCol();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getCol());
    }

    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }

    public boolean getColor(int boardSize) {
        int cellNumber = row * boardSize + col;
        if (row % 2 == 0) return cellNumber % 2 == 0;
        else return cellNumber % 2 != 0;
    }
}