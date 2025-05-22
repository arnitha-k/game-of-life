package com.arni.gameoflife;

import java.util.LinkedHashSet;
import java.util.Set;

public class Board {
    int[][] GLIDER = {
            {1, 0}, {2, 1}, {0, 2}, {1, 2}, {2, 2}
    };
    private Set<Point> liveCells = new LinkedHashSet<>();

    public void initializeBoard(int centerX, int centerY) {
        liveCells.clear();

        for (int[] offset : GLIDER) {
            liveCells.add(new Point(centerX + offset[0], centerY + offset[1]));
        }
        liveCells.forEach(System.out::println);

    }

    public Set<Point> getLiveCells() {
        return liveCells;
    }

    public void setLiveCells(Set<Point> liveCells) {
        this.liveCells = liveCells;
    }

    public void printBoard(int width, int height, int centerX, int centerY) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++)
                System.out.print(liveCells.contains(new Point(x + centerX, y + centerY)) ? "* " : ". ");
            System.out.println();
        }
        System.out.println();
    }
}
