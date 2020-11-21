package Dop.game2048.players;


import Dop.game2048.Game2048Field;
import Dop.game2048.GameField;

public class AI2048Player extends Game2048Player {
    private int max = 0;
    private int max_index;
    private int step = -1;
    private final int numberOfRun = 100;
    private Game2048Field gameField;
    private Random2048Player random2048Player;
    private int[] scores = new int[4];


    public AI2048Player(Game2048Field game2048Field) {
        super(game2048Field);
    }


    @Override
    protected void step() throws Exception {
        gameField = new GameField(4);
        gameField.copy(game2048Field);
        for(int i=0;i<4;i++) {
            max = 0;
            random2048Player = new Random2048Player(gameField);
            switch (i) {
                case 0:
                    gameField.moveUp();
                    for (int j = 0; j < numberOfRun; j++) {
                        while (gameField.isMoveAvailable())
                            random2048Player.step();
                        max += gameField.getScore();

                        gameField = new GameField(4);
                        gameField.copy(game2048Field);
                        random2048Player = new Random2048Player(gameField);
                        gameField.moveUp();
                    }
                    scores[i] = max;
                    max = 0;
                    break;
                case 1:
                    gameField.moveRight();
                    for (int j = 0; j < numberOfRun; j++) {
                        while (gameField.isMoveAvailable())
                            random2048Player.step();
                        max += gameField.getScore();

                        gameField = new GameField(4);
                        gameField.copy(game2048Field);
                        random2048Player = new Random2048Player(gameField);
                        gameField.moveRight();
                    }
                    scores[i] = max;
                    max = 0;
                    break;
                case 2:
                    gameField.moveDown();
                    for (int j = 0; j < numberOfRun; j++) {
                        while (gameField.isMoveAvailable())
                            random2048Player.step();
                        max += gameField.getScore();

                        gameField = new GameField(4);
                        gameField.copy(game2048Field);
                        random2048Player = new Random2048Player(gameField);
                        gameField.moveDown();
                    }
                    scores[i] = max;
                    max = 0;
                    break;
                case 3:
                    gameField.moveLeft();
                    for (int j = 0; j < numberOfRun; j++) {
                        while (gameField.isMoveAvailable())
                            random2048Player.step();
                        max += gameField.getScore();

                        gameField = new GameField(4);
                        gameField.copy(game2048Field);
                        random2048Player = new Random2048Player(gameField);
                        gameField.moveLeft();
                    }
                    scores[i] = max;
                    max = 0;
                    break;
            }
        }
        ////////////////////////////////////
        max = scores[0];
        max_index = 0;
        for(int i = 0;i<4;i++) {
            if(max<scores[i]) {
                max = scores[i];
                max_index = i;
            }
        }
        switch (max_index) {
            case 0:
                game2048Field.moveUp();
                break;
            case 1:
                game2048Field.moveRight();
                break;
            case 2:
                game2048Field.moveDown();
                break;
            case 3:
                game2048Field.moveLeft();
                break;
            default:
                System.out.println("ERROR");
                break;
        }
        max = 0;
        step = -1;

    }
}



