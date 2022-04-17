package baseball.gameUtil;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class PlayerNumber {

    BiPredicate<String, List<String>> dupCheckNumberFilter = (inputNumber, numberList) -> numberList.contains(inputNumber);

    public List<String> filteredGeneratedNumber(String inputNumber, List<String> numberList) {
        if (dupCheckNumberFilter.negate().test(inputNumber, numberList)) {
            numberList.add(inputNumber);
        }
        return numberList;
    }

    public int pitcherNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public List<String> pitcherGernerateNumber() {
        List<String> pitcherNumberList = new ArrayList<>();
        while (pitcherNumberList.size() < 3) {
            String inputNumber = String.valueOf(pitcherNumber());
            pitcherNumberList = filteredGeneratedNumber(inputNumber, pitcherNumberList);
        }
        return pitcherNumberList;
    }


}
