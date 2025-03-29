package org.example.business;

import org.example.model.Board;
import org.example.model.Cell;
import org.example.model.Snake;

public interface DeathCondition {
    boolean isSnakeDead(Board board, Snake snake, Cell cell);
}
