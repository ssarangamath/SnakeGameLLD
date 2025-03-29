package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Cell {
    private int row;
    private int column;
    private boolean hasFood;

    public Cell(int row, int column, boolean hasFood){
        this.row = row;
        this.column = column;
        this.hasFood = hasFood;
    }

    public Cell(Cell cell){
        this.row = cell.row;
        this.column = cell.column;
        this.hasFood = cell.hasFood;
    }
}
