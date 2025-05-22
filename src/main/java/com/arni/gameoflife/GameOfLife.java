package com.arni.gameoflife;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameOfLife {
    private static final int[][] DIRECTIONS = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}
    };
    private final Board board;

    public GameOfLife(Board board) {
        this.board = board;
    }

    public void nextGeneration() {
        Set<Point> current = board.getLiveCells();
        Map<Point, Integer> neighbourCount = new HashMap<>();

        for (Point p : current) {
            for (int[] dir : DIRECTIONS) {
                Point neighbour = new Point(p.x() + dir[0], p.y() + dir[1]);
                neighbourCount.put(neighbour, neighbourCount.getOrDefault(neighbour, 0) + 1);
            }
        }

        Set<Point> nextGen = new HashSet<>();

        for (Map.Entry<Point, Integer> e : neighbourCount.entrySet()) {
            Point cell = e.getKey();
            int count = e.getValue();
            if (count == 3 || (count == 2 && current.contains(cell))) {
                nextGen.add(cell);
            }
        }
        board.setLiveCells(nextGen);
    }
}
