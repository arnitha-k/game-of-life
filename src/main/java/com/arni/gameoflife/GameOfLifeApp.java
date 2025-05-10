package com.arni.gameoflife;

import java.util.Scanner;

public class GameOfLifeApp {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        System.out.println("Enter the required no. of rows for the board:");
        int rows=sc.nextInt();

        System.out.println("Enter the required no. of columns for the board:");
        int cols=sc.nextInt();

        System.out.println("Enter the generations to be built:");
        int generations=sc.nextInt();

        System.out.println("Size of the board is: "+rows+"x"+cols);
        System.out.println("Generations needed: "+generations);
        System.out.println();

        Board board = new Board(rows, cols);
        board.initializeBoard();

        GameOfLife game=new GameOfLife(board);

        System.out.println("First/Seed Generation: ");
        board.printBoard();

        for(int i=1;i<=generations;i++){
            game.nextGeneration();
            System.out.println("\nGeneration "+i+":");
            board.printBoard();
        }
    }
}
