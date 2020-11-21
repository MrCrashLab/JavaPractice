package Dop.game2048.players;


import Dop.game2048.Game2048Field;

public abstract class Game2048Player {
    protected Game2048Field game2048Field;

    public Game2048Player(Game2048Field game2048Field){
        this.game2048Field = game2048Field;
    }



    public void startGame() throws Exception {
        while (game2048Field.isMoveAvailable()) {
            System.out.println(game2048Field);
            step();
            //Thread.sleep(100);
        }
        System.out.println("GAME OVER");
        System.out.println(game2048Field);
    }


    protected abstract void step() throws Exception;
}
