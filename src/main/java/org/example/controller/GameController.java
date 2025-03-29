package org.example.controller;

import org.example.business.DeathCondition;
import org.example.dtos.Direction;
import org.example.dtos.GameResponse;
import org.example.dtos.GameStatus;
import org.example.dtos.MoveResult;
import org.example.model.Board;
import org.example.model.Cell;
import org.example.model.Snake;

import java.util.ArrayList;
import java.util.List;

public class GameController implements IGameController{
    private Board board;
    private Snake snake;
    private int score;
    private List<DeathCondition> deathConditions;
    private boolean gameOver;
    private GameStatus gameStatus;

    public GameController(Cell[][] cells, List<DeathCondition> deathConditionsInput){
        board = new Board(cells);
        snake = new Snake();
        deathConditions = new ArrayList<>(deathConditionsInput);
        gameOver = false;
        score = 0;
        gameStatus = GameStatus.NEW;
    }

    @Override
    public GameResponse move(Direction direction) {

        GameResponse gameResponse = new GameResponse();

        if(gameOver){
            gameStatus = GameStatus.ENDED;
            gameResponse.setGameStatus(gameStatus);
            gameResponse.setScore(score);
        }

        Direction.isValid(direction);

        Cell snakeHead = snake.getSnakeHead();

        Cell newSnakeHead = getNewSnakeHead(snakeHead, direction);

        if(!newSnakeHead.isHasFood()){
            this.snake.removeTail();
        }else{
            gameResponse.setMoveResult(MoveResult.FOOD_CONSUMED);
            this.score++;

            if(this.score == board.getTotalFoodProvided()){

                gameStatus = GameStatus.WON;
                gameResponse.setGameStatus(gameStatus);
                gameResponse.setScore(score);
                return gameResponse;
            }
        }

        for(DeathCondition deathCondition: deathConditions){
            boolean snakeDead = deathCondition.isSnakeDead(board, snake, newSnakeHead);

            if(snakeDead){
                gameOver = true;
                gameStatus = GameStatus.ENDED;
                gameResponse.setGameStatus(gameStatus);
                gameResponse.setMoveResult(MoveResult.SNAKE_BITE);
                gameResponse.setScore(score);
                return gameResponse;
            }
        }

        snake.updateSnakeHead(newSnakeHead);
        gameStatus = GameStatus.IN_PROGRESS;
        gameResponse.setGameStatus(gameStatus);
        gameResponse.setScore(score);
        return gameResponse;
    }

    private Cell getNewSnakeHead(Cell snakeHead, Direction direction){
        int row = snakeHead.getRow(), col = snakeHead.getColumn();

        switch(direction){
            case UP:
                row = (snakeHead.getRow()-1);
                if(row<0){
                    row  = board.getRows()-1;
                }
                break;
            case DOWN:
                row = (snakeHead.getRow()+1)%board.getRows();
                break;
            case LEFT:
                col = snakeHead.getColumn()-1;
                if(col<0){
                    row  = board.getCols()-1;
                }
                break;
            case RIGHT:
                col = (snakeHead.getColumn()+1)%board.getCols();
                break;
            default:
        }

        return new Cell(row, col, board.hasFood(row, col));
    }

    @Override
    public Integer getScore() {
        return 0;
    }

    @Override
    public void start() {
        this.gameStatus = GameStatus.NEW;
    }

    @Override
    public void end() {
        this.gameStatus = GameStatus.ENDED;
    }

    @Override
    public String display() {
       Cell[][] board =  this.board.getBoardDetails();
       List<Cell> snake = this.snake.getBody();

       StringBuilder sb = new StringBuilder();
       for(Cell[] cells: board){
           for(Cell cell: cells){
               if(snake.contains(cell)){
                   sb.append("=");
               }
               else if(cell.isHasFood()){
                   sb.append("f");
               }else {
                   sb.append("x");
               }
               sb.append(" ");
           }
           sb.append("/n");
       }
       return sb.toString();
    }

    public boolean gameOver(){
        return this.gameOver;
    }
}
