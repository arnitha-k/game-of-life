package com.arni.gameoflife;

import java.util.Random;

public class Board {
    private int[][] matrix;
    private final int rows;
    private final int cols;

    public Board(int rows,int cols){
        this.rows=rows;
        this.cols=cols;
        this.matrix=new int[rows][cols];
    }

    public void initializeBoard() {
        //Initialize 1s in the board array
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(2); // 0 or 1
            }
        }
    }

    public int[][] getMatrix(){
        return matrix;
    }

    public void setMatrix(int[][] matrix){
        this.matrix=matrix;
    }

    public int getRows(){
        return rows;
    }

    public int getCols(){
        return cols;
    }

    public void printBoard() {
        for(int[] row: matrix){
            for(int cell: row)
                System.out.print(cell==1? "1 " : "0 ");
            System.out.println();
        }
        System.out.println();
    }
}
