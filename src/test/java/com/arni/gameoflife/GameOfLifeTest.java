package com.arni.gameoflife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeTest {

    private Board board;
    private GameOfLife game;

    @BeforeEach
    public void setUp() {
        board = new Board();
        game = new GameOfLife(board);
    }

    @Test
    @DisplayName("Glider should move one cell diagonally down-right every 4 gens")
    public void testGliderMovementAfter1Gen() {
        board.initializeBoard(0, 0);
        game.nextGeneration();

        Set<Point> expectedLiveCells = Set.of(
                new Point(2, 2),
                new Point(0, 1),
                new Point(1, 2),
                new Point(1, 3),
                new Point(2, 1)
        );

        assertEquals(expectedLiveCells, board.getLiveCells(), "Generation 1 failed");
    }
}
