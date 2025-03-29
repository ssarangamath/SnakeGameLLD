package org.example.model;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Snake {
    private Deque<Cell> snake;
    private Cell snakeHead;

    public Snake(){
        this.snake = new LinkedList<>();
        this.snakeHead = new Cell(0, 0 , false);

        this.snake.add(this.snakeHead);
    }

    public List<Cell> getBody(){
        return new LinkedList<>(snake);
    }

    public Cell getSnakeHead(){
        return snake.peekFirst();
    }

    public Cell removeTail(){
        return this.snake.pollLast();
    }

    public Cell updateSnakeHead(Cell newSnakeHead){
        this.snake.offerFirst(newSnakeHead);

        return this.snake.peekFirst();
    }
}
