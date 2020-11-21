package Dop.game2048;
import Dop.game2048.players.AI2048Player;
import Dop.game2048.players.Game2048Player;

public class Main {
    public static void main(String[] args) throws Exception {
        GameField gameField = new GameField(4);
        gameField.generateCell();
        Game2048Player player = new AI2048Player(gameField);
        player.startGame();
    }
}
