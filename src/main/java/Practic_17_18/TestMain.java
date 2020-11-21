package Practic_17_18;

import java.io.IOException;

public class TestMain {
    public static void main(String[] args){
        CreatorMarkDown creatorMarkDown = new CreatorMarkDown("src/main/java");
        creatorMarkDown.createMD();
    }
}
