package baseball.view;

import baseball.ballType.Ball;
import baseball.ballType.BallType;
import baseball.ballType.Nothing;
import baseball.ballType.Strike;

import java.util.Collections;
import java.util.List;

public class BaseballGameView {

    public String printGameResult(List<BallType> resultList) {
        int nothing = Collections.frequency(resultList, new Nothing());
        if (nothing == 3) {
            return "낫싱";
        }
        return printStrike(resultList);

    }

    public String printStrike(List<BallType> resultList) {
        int strike = Collections.frequency(resultList, new Strike());
        if (strike == 3) {
            return "3스트라이크";
        }
        return printBall(resultList);
    }

    public String printBall(List<BallType> resultList) {
        int ball = Collections.frequency(resultList, new Ball());
        if (ball == 3) {
            return "3볼";
        }
        return printBallType(resultList);
    }

    public String printBallType(List<BallType> resultList) {
        int strike = Collections.frequency(resultList, new Strike());
        int ball = Collections.frequency(resultList, new Ball());
        return ball + "볼 " + strike + "스트라이크";
    }
}
