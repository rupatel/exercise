package com.apple.interview.exercise.chess.search;

import com.apple.interview.exercise.chess.search.board.Board;
import com.apple.interview.exercise.chess.search.cell.Cell;
import com.apple.interview.exercise.chess.search.piece.PieceType;

import java.util.Scanner;
import java.util.function.Function;

public class ChessSearch {
    public static void main(String args[]) {
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
        Cell start = new Cell(pr, pc);
        Cell goal = new Cell(gr, gc);
        Board board = new Board(8, getPieceType(opt), start, goal);
        board.findMin();
    }

    private static PieceType getPieceType(int opt) {
        switch (opt) {
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

    private static Function<Cell, Integer> getHeuristic(int opt, Cell goal) {
        switch (opt) {
            case 1:
                return cur -> {
                    int d1 = Math.abs(cur.getRow() - goal.getRow());
                    int d2 = Math.abs(cur.getCol() - goal.getCol());
                    int manhattan = d1 + d2;
                    return manhattan / 2;
                };
            case 2:
                return cur -> {
                    int d1 = Math.abs(cur.getRow() - goal.getRow());
                    int d2 = Math.abs(cur.getCol() - goal.getCol());
                    int manhattan = d1 + d2;
                    return manhattan / 3;
                };
            default:
                //never overestimate the distance to the goal node
                return cur -> 0;
        }
    }
}