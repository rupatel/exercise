package com.apple.interview.exercise.chess.search.board;

import com.apple.interview.exercise.chess.search.cell.Cell;
import com.apple.interview.exercise.chess.search.piece.PieceType;

import java.util.PriorityQueue;
import java.util.function.Function;

public class Board {
    private int size;
    private PieceType pieceType;
    private Cell start;
    private Cell goal;
    private Function<Cell,Integer> heuristic;

    public Board(int size, PieceType pieceType, Cell start, Cell goal){
        this(size,pieceType,start,goal, cur -> {
            int d1 = Math.abs(cur.getRow()- goal.getRow());
            int d2 = Math.abs(cur.getCol() - goal.getCol());
            int manhattan = d1+d2;
            return manhattan/3;
        });
    }

    public Board(int size, PieceType pieceType, Cell start, Cell goal, Function<Cell, Integer> heuristic) {
        this.size = size;
        this.pieceType = pieceType;
        this.start = start;
        this.goal = goal;
        this.heuristic = heuristic;
    }

    public long findMin(){
        //TODO Implement Search
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b) -> {
            int d1 = a.getDistFromStart() + heuristic.apply(a.getCell());
            int d2 = b.getDistFromStart() + heuristic.apply(b.getCell());
            return d1+d2;
        });
        return 0;
    }
}

class Node{
    private int distFromStart;
    private Cell cell;
    public Node(int distFromStart,Cell cell){
        this.cell = cell;
        this.distFromStart = distFromStart;
    }

    public int getDistFromStart() {
        return distFromStart;
    }

    public Cell getCell() {
        return cell;
    }

    public void setDistFromStart(int distFromStart) {
        this.distFromStart = distFromStart;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}