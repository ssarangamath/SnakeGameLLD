package org.example.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class GameResponse {
    private MoveResult moveResult;
    private GameStatus gameStatus;
    private Integer score;
}
