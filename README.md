Single Player Game

Game
  - id 
  - userId
  - GameDecision
  - startTime
  - endTime
  - score

GameDecision
 - WIN
 - LOSS
 - IN_PROGRESS
 - NOT STARTED

Score
  - int snakelength;

=================================================
Board
 - List<Cell>
 - int rows
 - int columns

Cell
 - int row
 - int col
 - boolean hasFood

ISnake
  - Cell getHead()
  - List<Cell> getBody()
  - int getTotalFoodConsumed()

Snake
 - cells;
 - head: Cell
 - totalFoodConsumed

GameResponse
  - moveResult: MoveResult
  - score: Integer

MoveResult
 - FOOD_CONSUMED, SNAKE_BITE, NORMAL_MOVE

Direction
  - U, D, L, R

GameState
  - NEW, STARTED, ENDED

IGameController
  - start()
  - end()
  - GameResponse move()
  - int getScore()
  - boolean isGameOver()

GameControllerImpl
  - board: Board
  - snake: Snake
  - gameState: GameState
  - gameOver: boolean
  - deathConditions : List<DeathCondition>

DeathCondition
 - isSnakeDead(board, newCell)

SnakeBiteCondition < DeathCondition
  - isSnakeDead(board, newCell)

WallHitCondition < DeathCondition
  -   isSnakeDead(board, newCell)

Functionalities
 - Board will be having Cells
 - SnakeHead will start from (0,0)
 - Snake will move in the direction provided
 - If the Cell has Food, Snake will grow.
 - If Cell is empty , snake will move
 - Snake will die, if it bites itself.


