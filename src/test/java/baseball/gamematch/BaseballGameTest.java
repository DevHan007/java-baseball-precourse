package baseball.gamematch;

import baseball.ballType.Ball;
import baseball.ballType.BallType;
import baseball.ballType.Nothing;
import baseball.ballType.Strike;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {
    BaseballGame baseballGame = new BaseballGame();

    @Test
    void 게임_테스트_스트라이크() {
        List<String> userNumberList = Arrays.asList("1", "2", "3");
        List<String> comNumberList = Arrays.asList("1", "2", "3");

        List<BallType> resultList = baseballGame.gameStart(comNumberList, userNumberList);
        assertThat(resultList)
                .hasSize(3)
                .containsExactly(new Strike(), new Strike(), new Strike());
    }

    @Test
    void 게임_테스트_스트라이크_볼() {
        List<String> userNumberList = Arrays.asList("1", "2", "3");
        List<String> comNumberList = Arrays.asList("2", "1", "3");

        List<BallType> resultList = baseballGame.gameStart(comNumberList, userNumberList);
        assertThat(resultList)
                .hasSize(3)
                .containsExactly(new Ball(), new Ball(), new Strike());
    }

    @Test
    void 게임_테스트_낫띵() {
        List<String> userNumberList = Arrays.asList("1", "2", "3");
        List<String> comNumberList = Arrays.asList("4", "5", "6");

        List<BallType> resultList = baseballGame.gameStart(comNumberList, userNumberList);
        assertThat(resultList)
                .hasSize(3)
                .containsExactly(new Nothing(), new Nothing(), new Nothing());

        int nothing = Collections.frequency(resultList,new Nothing());
        assertThat(nothing)
                .isEqualTo(3);
    }


}
