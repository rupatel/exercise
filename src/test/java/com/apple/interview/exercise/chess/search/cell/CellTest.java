package com.apple.interview.exercise.chess.search.cell;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {
    @Test
    public void getColor() {
        Cell c1 = new Cell(0,0);
        Cell c2 = new Cell(1,0);
        Cell c3 = new Cell(1,1);
        Cell c4 = new Cell(4,4);
        assertEquals(true,c1.getColor(8));
        assertEquals(false,c2.getColor(8));
        assertEquals(true,c3.getColor(8));
        assertEquals(true,c4.getColor(8));
    }
}
