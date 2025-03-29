package org.example.controller;

import org.example.dtos.Direction;
import org.example.dtos.GameResponse;

public interface IGameController {
    GameResponse move(Direction direction);
    Integer getScore();
    void start();
    void end();
    String display();
    boolean gameOver();
}
