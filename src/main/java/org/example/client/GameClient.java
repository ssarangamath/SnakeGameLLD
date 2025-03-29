package org.example.client;

import org.example.business.DeathCondition;
import org.example.business.SnakeBiteCondition;
import org.example.controller.GameController;
import org.example.controller.IGameController;
import org.example.dtos.Direction;
import org.example.dtos.GameResponse;
import org.example.model.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameClient implements IGameClient{
    private IGameController gameController;

    public GameClient(){
        Cell[][] cells = new Cell[3][3];

        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
                cells[i][j] = new Cell(i, j, false);
            }
        }

        cells[0][1].setHasFood(true);
        cells[1][2].setHasFood(true);
        cells[2][0].setHasFood(true);

        List<DeathCondition> deathConditionList = new ArrayList<>();

        DeathCondition snakeBiteCondition = new SnakeBiteCondition();
        deathConditionList.add(snakeBiteCondition);

        gameController = new GameController(cells, deathConditionList);
    }

    @Override
    public void play() {
        this.gameController.start();;

        GameResponse gameResponse = null;

        while (!this.gameController.gameOver()){
            String directionStr = getDirectionFromUser();
            Direction direction = Direction.valueOf(directionStr);
            gameResponse = this.gameController.move(direction);

            System.out.println(gameResponse);
            System.out.println(gameController.display());
        }
    }

    private String getDirectionFromUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the direction: LEFT, RIGHT, DOWN, UP");

        String direction = sc.nextLine();
        System.out.println();
        return direction;
    }

    @Override
    public void end() {
        this.gameController.end();
    }

    @Override
    public void start() {
        this.gameController.start();
    }
}
