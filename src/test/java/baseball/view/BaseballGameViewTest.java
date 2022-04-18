package baseball.view;

import baseball.ballType.BallType;
import baseball.gamematch.BaseballGame;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameViewTest {
    BaseballGame baseballGame = new BaseballGame();
    BaseballGameView baseballGameView = new BaseballGameView();

    @Test
    void 게임결과_표출_테스트_3스트라이크() {
        List<String> userNumberList = Arrays.asList("1", "2", "3");
        List<String> comNumberList = Arrays.asList("1", "2", "3");

        List<BallType> resultList = baseballGame.gameStart(comNumberList, userNumberList);
        assertThat(baseballGameView.printGameResult(resultList))
                .isEqualTo("3스트라이크");
    }

    @Test
    void 게임결과_표출_테스트_2볼_1스트라이크() {
        List<String> userNumberList2 = Arrays.asList("5", "9", "7");
        List<String> comNumberList2 = Arrays.asList("5", "8", "9");

        List<BallType> resultList2 = baseballGame.gameStart(comNumberList2, userNumberList2);
        assertThat(baseballGameView.printGameResult(resultList2))
                .isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 게임결과_표출_테스트_낫싱() {
        List<String> userNumberList3 = Arrays.asList("1", "2", "3");
        List<String> comNumberList3 = Arrays.asList("4", "5", "6");

        List<BallType> resultList3 = baseballGame.gameStart(comNumberList3, userNumberList3);
        assertThat(baseballGameView.printGameResult(resultList3))
                .isEqualTo("낫싱");
    }

    @Test
    void 게임결과_표출_테스트_3볼() {
        List<String> userNumberList4 = Arrays.asList("1", "2", "3");
        List<String> comNumberList4 = Arrays.asList("3", "1", "2");

        List<BallType> resultList4 = baseballGame.gameStart(comNumberList4, userNumberList4);
        assertThat(baseballGameView.printGameResult(resultList4))
                .isEqualTo("3볼");
    }


}
