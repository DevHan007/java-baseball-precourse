package baseball.view;

import baseball.ballType.Ball;
import baseball.ballType.BallType;
import baseball.ballType.Nothing;
import baseball.ballType.Strike;
import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;
import java.util.List;

public class BaseballGameView {

    public String printGameResult(List<BallType> resultList) {
        int nothing = Collections.frequency(resultList, new Nothing());
        if (nothing == 3) {
            System.out.println("낫싱");
            return "낫싱";
        }
        System.out.println(printThreeBall(resultList) + printThreeStrike(resultList));
        return printThreeBall(resultList) + printThreeStrike(resultList);
    }

    public String printThreeStrike(List<BallType> resultList) {
        int strike = Collections.frequency(resultList, new Strike());
        if (strike == 3) {
            return "3스트라이크";
        }
        return printTwoStrike(resultList);
    }

    public String printTwoStrike(List<BallType> resultList) {
        int strike = Collections.frequency(resultList, new Strike());
        if (strike == 2) {
            return "2스트라이크";
        }
        return printOneStrike(resultList);
    }

    public String printOneStrike(List<BallType> resultList) {
        int strike = Collections.frequency(resultList, new Strike());
        if (strike == 1) {
            return "1스트라이크";
        }
        return "";
    }

    public String printThreeBall(List<BallType> resultList) {
        int ball = Collections.frequency(resultList, new Ball());
        if (ball == 3) {
            return "3볼";
        }
        return printTwoBall(resultList);
    }

    public String printTwoBall(List<BallType> resultList) {
        int ball = Collections.frequency(resultList, new Ball());
        if (ball == 2) {
            return "2볼";
        }
        return printOneBall(resultList);
    }

    public String printOneBall(List<BallType> resultList) {
        int ball = Collections.frequency(resultList, new Ball());
        if (ball == 1) {
            return "1볼";
        }
        return "";
    }

    public String userNumberInput() {
        System.out.println("숫자를 입력해주세요: ");
        return Console.readLine();
    }
}
