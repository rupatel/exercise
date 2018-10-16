package com.apple.interview.exercise.chess.search.board;

import com.apple.interview.exercise.chess.search.cell.Cell;
import com.apple.interview.exercise.chess.search.piece.PieceType;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.Function;

public class Board {
    private int size;
    private PieceType pieceType;
    private Cell start;
    private Cell goal;
    private Function<Cell, Integer> heuristic;

    public Board(int size, PieceType pieceType, Cell start, Cell goal) {
        this(size, pieceType, start, goal, cur -> {
            int d1 = Math.abs(cur.getRow() - goal.getRow());
            int d2 = Math.abs(cur.getCol() - goal.getCol());
            int manhattan = d1 + d2;
            return manhattan / 3;
        });
    }

    public Board(int size, PieceType pieceType, Cell start, Cell goal, Function<Cell, Integer> heuristic) {
        if (goal.getRow() >= size || goal.getRow() < 0 || goal.getCol() >= size || goal.getCol() < 0 ||
                start.getRow() >= size || start.getRow() < 0 || start.getCol() >= size || start.getCol() < 0) {
            throw new IllegalStateException("invalid goal/start state");

        }
        this.size = size;
        this.pieceType = pieceType;
        this.start = start;
        this.goal = goal;
        this.heuristic = heuristic;
    }

    public long findMin() {
        if (pieceType == PieceType.BISHOP && start.getColor(size) != goal.getColor(size)) {
            System.out.println("goal state cannnot be reached");
            return -1;
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> {
            int d1 = a.getDistFromStart() + heuristic.apply(a.getCell());
            int d2 = b.getDistFromStart() + heuristic.apply(b.getCell());
            return d1 - d2;
        });
        Set<Node> close_set = new HashSet<>();
        pq.offer(new Node(0, start));
        Node goalState = null;
        while (!pq.isEmpty()) {
            Node p = pq.poll();
            close_set.add(p);
            if (p.getCell().equals(goal)) {
                goalState = p;
                break;
            } else {
                List<Cell> neighbors = pieceType.getNeighbors(p.getCell(), size);
                for (Cell v : neighbors) {
                    Integer cost = new Integer(p.getDistFromStart() + 1);
                    Node c = new Node(cost, v);
                    if (!close_set.contains(c)) {
                        c.setParent(p);
                        pq.offer(c);
                    }
                }
            }
        }

        if (goalState != null) {
            System.out.println("Min dist travelled:" + goalState.getDistFromStart());
            print(goalState);
            return goalState.getDistFromStart();
        } else {
            System.out.println("goal state cannnot be reached");
            return -1;
        }
    }

    public void print(Node goal) {
        while (goal != null) {
            System.out.println(goal.getCell());
            goal = goal.getParent();
        }
    }
}

class Node {
    private int distFromStart;
    private Cell cell;
    private Node parent;

    public Node(int distFromStart, Cell cell) {
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

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}