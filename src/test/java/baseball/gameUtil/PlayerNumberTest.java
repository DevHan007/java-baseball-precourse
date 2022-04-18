package baseball.gameUtil;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;


public class PlayerNumberTest {
    PlayerNumber playerNumber = new PlayerNumber();

    @Test
    void 컴퓨터_숫자_생성_테스트() {
        List<String> resultList = playerNumber.pitcherGernerateNumber();
        assertThat(resultList)
                .hasSize(3)
                .isNotEmpty()
                .filteredOn(number -> Integer.parseInt(number) > 0)
                .filteredOn(number -> Integer.parseInt(number) < 10);
    }

    @Test
    void 사용자_숫자입력_테스트() {
        String userInput1 = "123";
        List<String> resultList = playerNumber.batterGernerateNumber(userInput1);
        assertThat(resultList)
                .hasSize(3)
                .isNotEmpty()
                .filteredOn(number -> Integer.parseInt(number) > 0)
                .filteredOn(number -> Integer.parseInt(number) < 10);
    }

    @Test
    void 입력_예외_테스트() {
        String userInput3 = "1234ddd";
        assertThatThrownBy(() -> playerNumber.batterGernerateNumber(userInput3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못입력하였습니다.");

        String userInput4 = "012";
        assertThatThrownBy(() -> playerNumber.batterGernerateNumber(userInput4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못입력하였습니다.");

        String userInput5 = "111";
        assertThatThrownBy(() -> playerNumber.batterGernerateNumber(userInput5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못입력하였습니다.");

        String userInput6 = "1234";
        assertThatThrownBy(() -> playerNumber.batterGernerateNumber(userInput6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못입력하였습니다.");
    }

}
