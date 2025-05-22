package com.arni.gameoflife;

import java.util.Scanner;

public class GameOfLifeApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter visible height for the board:");
        int height = sc.nextInt();

        System.out.println("Enter visible width for the board:");
        int width = sc.nextInt();

        System.out.println("Enter the generations to be built:");
        int generations = sc.nextInt();
        System.out.println();

        Board board = new Board();
        int centerX = 0, centerY = 0;
        board.initializeBoard(centerX, centerY);

        GameOfLife game = new GameOfLife(board);

        System.out.println("First/Seed Generation: ");
        board.printBoard(width, height, centerX, centerY);

        for (int i = 1; i <= generations; i++) {
            game.nextGeneration();
            System.out.println("\nGeneration " + i + ":");
            board.printBoard(width, height, centerX, centerY);
            board.getLiveCells().forEach(System.out::println);
        }
    }

}
