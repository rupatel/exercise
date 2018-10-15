package com.apple.interview.exercise.chess.search.piece;
import com.apple.interview.exercise.chess.search.cell.Cell;
public class Piece {
    private Cell pos;
    private PieceType peiceType;
    public Piece(Cell pos, PieceType peiceType) {
        this.peiceType = peiceType;
        this.pos = pos;
    }

    public Cell getPos() {
        return pos;
    }

    public PieceType getPeiceType() {
        return peiceType;
    }

    public void setPos(Cell pos) {
        this.pos = pos;
    }

    public void setPeiceType(PieceType peiceType) {
        this.peiceType = peiceType;
    }
}