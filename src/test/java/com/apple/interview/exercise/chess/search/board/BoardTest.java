package com.apple.interview.exercise.chess.search.board;

import com.apple.interview.exercise.chess.search.cell.Cell;
import com.apple.interview.exercise.chess.search.piece.PieceType;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void findMin() {
        Cell start = new Cell(0,0);
        Cell goal = new Cell(0,4);
        Board board = new Board(8, PieceType.BISHOP, start, goal);
        assertEquals(2,board.findMin());

        start = new Cell(0,0);
        goal = new Cell(7,7);
        board = new Board(8, PieceType.BISHOP, start, goal);
        assertEquals(1,board.findMin());

        start = new Cell(0,0);
        goal = new Cell(0,7);
        board = new Board(8, PieceType.BISHOP, start, goal);
        assertEquals(-1,board.findMin());

        start = new Cell(4,5);
        goal = new Cell(5,2);
        board = new Board(8, PieceType.BISHOP, start, goal);
        assertEquals(2,board.findMin());

        start = new Cell(0,0);
        goal = new Cell(1,0);
        board = new Board(8, PieceType.BISHOP, start, goal);
        assertEquals(-1,board.findMin());

        start = new Cell(0,0);
        goal = new Cell(0,2);
        board = new Board(8, PieceType.KNIGHT, start, goal);
        assertEquals(2,board.findMin());

        start = new Cell(0,0);
        goal = new Cell(7,7);
        board = new Board(8, PieceType.KNIGHT, start, goal);
        assertEquals(6,board.findMin());

        start = new Cell(0,0);
        goal = new Cell(7,7);
        board = new Board(8, PieceType.KING, start, goal);
        assertEquals(7,board.findMin());

        start = new Cell(5,5);
        goal = new Cell(7,4);
        board = new Board(8, PieceType.KING, start, goal);
        assertEquals(2,board.findMin());


        start = new Cell(4,4);
        goal = new Cell(5,1);
        board = new Board(8, PieceType.KING, start, goal);
        assertEquals(3,board.findMin());
    }
}