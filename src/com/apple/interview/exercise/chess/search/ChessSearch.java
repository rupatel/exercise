package com.apple.interview.exercise.chess.search;

import com.apple.interview.exercise.chess.search.board.Board;
import com.apple.interview.exercise.chess.search.cell.Cell;
import com.apple.interview.exercise.chess.search.piece.Piece;
import com.apple.interview.exercise.chess.search.piece.PieceType;

import java.util.Scanner;

public class ChessSearch {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER PIECE TYPE:");
        System.out.println("1)KING");
        System.out.println("2)KNIGHT");
        System.out.println("3)BISHOP");
        int opt = sc.nextInt();

        System.out.println("ENTER INITIAL ROW OF PIECE:");
        int pr = sc.nextInt();
        System.out.println("ENTER INITIAL COL OF PIECE:");
        int pc = sc.nextInt();

        System.out.println("ENTER ROW OF GOAL STATE:");
        int gr = sc.nextInt();
        System.out.println("ENTER COL OF GOAL STATE:");
        int gc = sc.nextInt();

        Piece piece = new Piece(new Cell(pr,pc),getPieceType(opt));
        Board board = new Board(piece,new Cell(gr,gc));

        System.out.println("Min steps to reach goal state" + board.findMin());
    }

    private static PieceType getPieceType(int opt){
        switch (opt){
            case 1:
                return PieceType.KING;
            case 2:
                return PieceType.KNIGHT;
            case 3:
                return PieceType.BISHOP;
            default:
                return PieceType.KING;
        }
    }
}