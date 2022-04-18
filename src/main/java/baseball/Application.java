package baseball;

import baseball.gamematch.BaseballGame;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        while (baseballGame.isGameFlag()) {
            baseballGame.startApp();
        }
    }
}
