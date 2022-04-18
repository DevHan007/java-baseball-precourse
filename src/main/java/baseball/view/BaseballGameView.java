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
        int strike = Collections.frequency(resultList, new Strike());
        int ball = Collections.frequency(resultList, new Ball());
        if (nothing == 3) {
            return "낫싱";
        }
        return printBallType(strike, ball);
    }

    public String printBallType(int strike, int ball) {
        return printThreeBall(ball) + printThreeStrike(strike);
    }

    public String printThreeStrike(int strike) {
        if (strike == 3) {
            return "3스트라이크";
        }
        return printTwoStrike(strike);
    }

    public String printTwoStrike(int strike) {
        if (strike == 2) {
            return "2스트라이크";
        }
        return printOneStrike(strike);
    }

    public String printOneStrike(int strike) {
        if (strike == 1) {
            return "1스트라이크";
        }
        return "";
    }

    public String printThreeBall(int ball) {
        if (ball == 3) {
            return "3볼";
        }
        return printTwoBall(ball);
    }

    public String printTwoBall(int ball) {
        if (ball == 2) {
            return "2볼 ";
        }
        return printOneBall(ball);
    }

    public String printOneBall(int ball) {
        if (ball == 1) {
            return "1볼 ";
        }
        return "";
    }

    public String inputUserNumber() {
        System.out.print("숫자를 입력해주세요: ");
        String number = Console.readLine();
        return number;
    }

    public String exitGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로시작하려면 1, 종료하시려면 2를 입력하세요");
        String number = Console.readLine();
        return number;
    }

}
