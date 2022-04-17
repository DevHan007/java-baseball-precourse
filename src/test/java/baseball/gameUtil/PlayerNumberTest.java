package baseball.gameUtil;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

        String userInput2 = "1234";
        List<String> resultList2 = playerNumber.batterGernerateNumber(userInput2);
        assertThat(resultList2)
                .hasSize(4);

        String userInput3 = "1234ddd";
        List<String> resultList3 = playerNumber.batterGernerateNumber(userInput3);
        assertThat(resultList3)
                .hasSize(0);

        String userInput4 = "012";
        List<String> resultList4 = playerNumber.batterGernerateNumber(userInput4);
        assertThat(resultList4)
                .hasSize(0);

        String userInput5 = "111";
        List<String> resultList5 = playerNumber.batterGernerateNumber(userInput5);
        assertThat(resultList5)
                .hasSize(1)
                .containsExactly("1");
    }

}
