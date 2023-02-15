package src;

import java.util.Scanner;

public class SnakeGame {
    Board theBoard;
    SnakeArr snake;
    public SnakeGame(int width, int height){
        theBoard = new Board(width, height);
        snake = new SnakeArr(theBoard);
    }
    public Direction scanMove(Direction prev) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Next move:\na : left | d : right | w : up | s : down");
        String input = keyboard.next();
        input = input.toLowerCase();
        System.out.println(input);

        if (input.equals("a")) {
            return Direction.LEFT;
        } else if (input.equals("d")) {
            return Direction.RIGHT;
        } else if (input.equals("w")) {
            return Direction.UP;
        } else if (input.equals("s")) {
            return Direction.DOWN;
        }
        return Direction.PREV;
    }
    public void runGame(){
        theBoard.printBoard();
        boolean impacted = false;
        int iteration = 0;
        Direction input = Direction.UP;
        while(!impacted){
            input = scanMove(input);
            snake.updateDirections(input);

            /* Clear the snake off the board and move snake parts in their internal
               coordinates and replace snake (except head) on board*/
            for (int i = 0; i < snake.getLen(); i++) {
                theBoard.setObject(snake.getPart(i).getX(), snake.getPart(i).getY(), null);
                snake.movePart(i);
                if (i > 0) {
                    theBoard.setObject(snake.getPart(i).getX(), snake.getPart(i).getY(), snake.getPart(i));
                }
            }
            // Move head of snake snakes[0] checking for impacts/foods
            if (snake.getPart(0).getX() >= theBoard.getWidth() || snake.getPart(0).getX() < 0 ||
                    snake.getPart(0).getY() >= theBoard.getHeight() || snake.getPart(0).getY() < 0) {
                System.out.println("Crashed into wall!");
                impacted = true;
            } else {
                impacted = snake.checkImpact(theBoard);
            }
            if (!impacted) {
                theBoard.setObject(snake.getPart(0).getX(), snake.getPart(0).getY(), snake.getPart(0));
            }
            if (iteration % 5 == 0) {
                theBoard.randomFood();
            }
            iteration++;
            theBoard.printBoard();
        }
    }

}
