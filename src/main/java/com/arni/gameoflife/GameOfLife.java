package com.arni.gameoflife;

public class GameOfLife {
    private final Board board;
    private static final  int[][] directions={
            {-1,-1},
            {-1,0},
            {-1,1},
            {0,-1},
            {0,1},
            {1,-1},
            {1,0},
            {1,1}
    };

    public GameOfLife(Board board){
        this.board=board;
    }

    public void nextGeneration() {
        int row=board.getRows();
        int col=board.getCols();
        int[][] matrix=board.getMatrix();

        //First Pass: mark cells for state changes with -1,2 for live to dead and dead to live respectively.
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                int liveNeighbours=countLiveNeighbours(i,j,matrix);

                //Live to Dead-Rule 1 and 3
                if(matrix[i][j]==1 && (liveNeighbours< 2 || liveNeighbours >3)) matrix[i][j] =-1;

                //Dead to Live-Rule 4
                if(matrix[i][j]==0 && liveNeighbours==3) matrix[i][j] = 2;
            }
        }

        //Second Pass:finalize the state changes
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++) {
                if(matrix[i][j]>0) matrix[i][j]=1; //cells with 1,2 are live cells
                else matrix[i][j]=0; //cells with -1,0 dead cells
            }
        }
        board.setMatrix(matrix);

    }

    private int countLiveNeighbours(int i, int j, int[][] matrix) {
        int liveNeighbours=0;

        // count live neighbours
        for(int[] dir : directions){
            int x=i+dir[0];
            int y=j+dir[1];
            if(x>=0 && x<board.getRows() &&
                    y>=0 && y<board.getCols() &&
                        Math.abs(matrix[x][y])==1)
                liveNeighbours++;
        }
        return liveNeighbours;
    }
}
