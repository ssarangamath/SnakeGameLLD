package org.example.business;

import org.example.business.exception.CellNotValidException;
import org.example.business.exception.SnakeNotExistsException;
import org.example.model.Board;
import org.example.model.Cell;
import org.example.model.Snake;

import java.util.Objects;

public class SnakeBiteCondition implements DeathCondition{
    @Override
    public boolean isSnakeDead(Board board, Snake snake, Cell cell) {
        if(Objects.isNull(snake)){
            throw new SnakeNotExistsException("Snake is Null");
        }

        if(Objects.isNull(cell)){
            throw new CellNotValidException("Cell is not valid");
        }

        if(snake.getBody().contains(cell)){
            return true;
        }

        return false;
    }
}
