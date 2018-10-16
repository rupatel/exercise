package com.apple.interview.exercise.chess.search.piece;

import com.apple.interview.exercise.chess.search.cell.Cell;

import java.util.ArrayList;
import java.util.List;

/**
 * This enum represents the type of the piece: King, Knight, Bishop
 */
public enum PieceType {
    KING {
        @Override
        public List<Cell> getNeighbors(Cell cell, int boardSize) {
            int r = cell.getRow();
            int c = cell.getCol();
            int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
            List<Cell> neighbors = new ArrayList<Cell>();
            for (int k = 0; k < dirs.length; k++) {
                int nextRow = r + dirs[k][0];
                int nextCol = c + dirs[k][1];
                if (nextRow >= 0 && nextCol >= 0 && nextRow < boardSize && nextCol < boardSize)
                    neighbors.add(new Cell(nextRow, nextCol));
            }
            return neighbors;
        }
    },
    KNIGHT {
        @Override
        public List<Cell> getNeighbors(Cell cell, int boardSize) {
            int r = cell.getRow();
            int c = cell.getCol();
            int[][] dirs = {{2, 1}, {-2, 1}, {2, -1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
            List<Cell> neighbors = new ArrayList<Cell>();
            for (int k = 0; k < dirs.length; k++) {
                int nextRow = r + dirs[k][0];
                int nextCol = c + dirs[k][1];
                if (nextRow >= 0 && nextCol >= 0 && nextRow < boardSize && nextCol < boardSize)
                    neighbors.add(new Cell(nextRow, nextCol));
            }
            return neighbors;
        }
    },
    BISHOP {
        @Override
        public List<Cell> getNeighbors(Cell cell, int boardSize) {
            int r = cell.getRow();
            int c = cell.getCol();
            List<Cell> neighbors = new ArrayList<Cell>();
            for (int i = r + 1, j = c + 1; i < boardSize && j < boardSize; i++, j++) {
                neighbors.add(new Cell(i, j));
            }
            for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
                neighbors.add(new Cell(i, j));
            }
            for (int i = r - 1, j = c + 1; i >= 0 && j < boardSize; i--, j++) {
                neighbors.add(new Cell(i, j));
            }
            for (int i = r + 1, j = c - 1; i < boardSize && j >= 0; i++, j--) {
                neighbors.add(new Cell(i, j));
            }
            return neighbors;
        }
    };

    /**
     *
     * @param c : the cell on chess board
     * @param boardSize: size of chess board
     * @return: all the neighbors of this piece (positioned at cell)
     */
    public abstract List<Cell> getNeighbors(Cell c, int boardSize);
}