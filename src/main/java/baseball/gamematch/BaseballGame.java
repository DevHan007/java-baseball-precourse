package baseball.gamematch;

import baseball.ballType.Ball;
import baseball.ballType.BallType;
import baseball.ballType.Nothing;
import baseball.ballType.Strike;
import baseball.gameUtil.PlayerNumber;
import baseball.view.BaseballGameView;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private PlayerNumber playerNumber;
    private BaseballGameView baseballGameView;
    private List<String> pitcherNumber;
    private boolean gameFlag = true;

    public BaseballGame() {
        this.playerNumber = new PlayerNumber();
        this.baseballGameView = new BaseballGameView();
        this.pitcherNumber = playerNumber.pitcherGernerateNumber();
    }

    public void startApp() {
        String result = baseballGameView.printGameResult(gameStart(pitcherNumber, playerNumber.batterGernerateNumber(baseballGameView.inputUserNumber())));
        System.out.println(result);
        if ("3스트라이크".equals(result)) {
            setGameFlag(restartGame(baseballGameView.exitGame()));
            this.pitcherNumber = playerNumber.pitcherGernerateNumber();
        }
    }

    public List<BallType> gameStart(List<String> pitcherList, List<String> batterList) {
        List<BallType> resultList = new ArrayList<>();
        for (int swingIdx = 0; swingIdx < batterList.size(); swingIdx++) {
            resultList.add(progressGame(pitcherList, batterList.get(swingIdx), swingIdx));
        }
        return resultList;
    }

    public BallType progressGame(List<String> pitcherList, String swing, int swingIdx) {
        if (pitcherList.contains(swing)) {
            return (matchBallType(pitcherList, swing, swingIdx));
        }
        return new Nothing();
    }

    public BallType matchBallType(List<String> pitcherList, String swing, int swingIdx) {
        if (swing.equals(pitcherList.get(swingIdx))) return new Strike();
        return new Ball();
    }

    public boolean isGameFlag() {
        return gameFlag;
    }

    public void setGameFlag(boolean gameFlag) {
        this.gameFlag = gameFlag;
    }

    public boolean restartGame(String inputNumber) {
        boolean restartFlag = validRestartFlag(inputNumber);
        if (restartFlag == false) {
            System.out.print("게임 종료");
        }
        return restartFlag;
    }

    public boolean validRestartFlag(String restartFlag) {
        if (!"1".equals(restartFlag) && !"2".equals(restartFlag)) {
            throw new IllegalArgumentException("잘못입력하였습니다");
        }
        if ("2".equals(restartFlag)) {
            return false;
        }
        return true;
    }
}
