package com.apple.interview.exercise.chess.search.com.apple.interview.exercise.chess.search.piece;

import com.apple.interview.exercise.chess.search.cell.Cell;
import com.apple.interview.exercise.chess.search.piece.PieceType;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class PieceTypeTest {
    @Test
    public void getNeighbors(){
        Cell c = new Cell(4,4);
        List<Cell> neighbors = PieceType.BISHOP.getNeighbors(c,8);
        List<Cell> exp = new ArrayList<Cell>();
        exp.add(new Cell(5,5));
        exp.add(new Cell(6,6));
        exp.add(new Cell(7,7));
        exp.add(new Cell(3,3));
        exp.add(new Cell(2,2));
        exp.add(new Cell(1,1));
        exp.add(new Cell(0,0));
        exp.add(new Cell(5,3));
        exp.add(new Cell(6,2));
        exp.add(new Cell(7,1));
        exp.add(new Cell(3,5));
        exp.add(new Cell(2,6));
        exp.add(new Cell(1,7));
        Assert.assertThat(exp,Matchers.containsInAnyOrder(neighbors.toArray()));


        c = new Cell(4,4);
        neighbors = PieceType.KING.getNeighbors(c,8);
        exp = new ArrayList<Cell>();
        exp.add(new Cell(5,5));
        exp.add(new Cell(3,3));
        exp.add(new Cell(3,5));
        exp.add(new Cell(5,3));
        exp.add(new Cell(4,5));
        exp.add(new Cell(4,3));
        exp.add(new Cell(3,4));
        exp.add(new Cell(5,4));
        Assert.assertThat(exp,Matchers.containsInAnyOrder(neighbors.toArray()));

        c = new Cell(4,4);
        neighbors = PieceType.KNIGHT.getNeighbors(c,8);
        exp = new ArrayList<Cell>();
        exp.add(new Cell(6,5));
        exp.add(new Cell(2,5));
        exp.add(new Cell(6,3));
        exp.add(new Cell(2,3));
        exp.add(new Cell(5,6));
        exp.add(new Cell(5,2));
        exp.add(new Cell(3,6));
        exp.add(new Cell(3,2));
        Assert.assertEquals(neighbors,exp);

        c = new Cell(0,0);
        neighbors = PieceType.KNIGHT.getNeighbors(c,8);
        exp = new ArrayList<Cell>();
        exp.add(new Cell(2,1));
        exp.add(new Cell(1,2));
        Assert.assertThat(exp,Matchers.containsInAnyOrder(neighbors.toArray()));
    }
}
