package com.arni.gameoflife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testInitializeBoardWithGlider() {
        board.initializeBoard(10, 10);

        Set<Point> expectedLiveCells = new HashSet<>();
        expectedLiveCells.add(new Point(11, 10));
        expectedLiveCells.add(new Point(12, 11));
        expectedLiveCells.add(new Point(10, 12));
        expectedLiveCells.add(new Point(11, 12));
        expectedLiveCells.add(new Point(12, 12));

        assertEquals(expectedLiveCells, board.getLiveCells(), "Glider pattern should be initialized correctly");

    }
}
