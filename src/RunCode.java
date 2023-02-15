package src;
public class RunCode {
    public static void main(String[] args) {
        int boardWidth = 7;
        int boardHeight = 7;
        SnakeGame game = new SnakeGame(boardWidth, boardHeight);
        game.runGame();
    }
}