package com.apple.interview.exercise.chess.search.board;

import com.apple.interview.exercise.chess.search.cell.Cell;
import com.apple.interview.exercise.chess.search.piece.Piece;

public class Board {
    private int size;
    Piece piece;
    Cell goal;

    public Board(Piece piece, int size, Cell goal){
        this.piece = piece;
        this.size = size;
        this.goal = goal;
    }

    public Board(Piece piece,Cell goal){
        this(piece,8,goal);
    }

    public long findMin(){
        //TODO Implement Search
        return 0;
    }
}