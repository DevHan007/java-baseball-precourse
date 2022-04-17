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

}
