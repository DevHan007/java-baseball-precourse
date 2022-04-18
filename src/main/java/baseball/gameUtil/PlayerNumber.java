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

    public List<String> pitcherGernerateNumber() {
        List<String> pitcherNumberList = new ArrayList<>();
        while (pitcherNumberList.size() < 3) {
            pitcherNumberList = filteredGeneratedNumber(String.valueOf(Randoms.pickNumberInRange(1, 9)), pitcherNumberList);
        }
        return pitcherNumberList;
    }

    public List<String> batterGernerateNumber(String inputNumber) {
        List<String> batterNumberList = new ArrayList<>();
        for (String number : convertStringList(inputNumber.replaceAll(" ", ""))) {
            batterNumberList = filteredGeneratedNumber(number, batterNumberList);
        }
        if (batterNumberList.size() != 3) {
            throw new IllegalArgumentException("잘못입력하였습니다.");
        }
        return batterNumberList;
    }

    public List<String> convertStringList(String targetNumber) {
        List<String> userNumberList = new ArrayList<>();
        for (char ch : targetNumber.toCharArray()) {
            char inputNumber = ch;
            checkTargetNumber(inputNumber);
            userNumberList.add(String.valueOf(ch));
        }
        return userNumberList;
    }

    public void checkTargetNumber(char targetNumber) {
        if (!Character.isDigit(targetNumber) || Character.getNumericValue(targetNumber) < 1) {
            throw new IllegalArgumentException("잘못입력하였습니다.");
        }
    }

    public List<String> checkPitcherNumber(List<String> pitcherNumber) {
        if (pitcherNumber == null || pitcherNumber.size() == 0) {
            return pitcherGernerateNumber();
        }
        return pitcherNumber;
    }

}
