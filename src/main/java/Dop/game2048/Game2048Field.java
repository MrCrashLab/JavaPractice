package Dop.game2048;

    public interface Game2048Field {
        int getSize();
        
        CellHolder[][] getCells();

        Cell[][] getFieldState();
        
        LineHolder[] getVerticalLines();

        LineHolder[] getHorizontalLines();
            
        void moveRight();

        void moveDown();

        void moveLeft();

        void moveUp();

        boolean isMoveAvailable();

        void generateCell();

        int getScore();


        void copy(Game2048Field game2048Field);

    }
