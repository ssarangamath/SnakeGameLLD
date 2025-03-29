package org.example.model;

public class Board {
    private int rows;
    private int cols;
    private Cell[][] board;
    private int totalFoodProvided;

    public Board(Cell[][] board){
        totalFoodProvided = 0;
        this.board = new Cell[board.length][board[0].length];

        int i=0, j=0;
        for(Cell[] cells: board){
            for(Cell cell: cells){
                board[i][j] = new Cell(cell);
                j++;

                if(cell.isHasFood()){
                    totalFoodProvided++;
                }
            }
            i++;
        }
    }

    public int getRows(){
        return this.rows;
    }

    public int getCols(){
        return this.cols;
    }

    public boolean hasFood(int row, int col){
        return board[row][col].isHasFood();
    }

    public int getTotalFoodProvided(){
        return this.totalFoodProvided;
    }

    public Cell[][] getBoardDetails(){
        return this.board;
    }
}
