package baseball.gamematch;

import baseball.ballType.Ball;
import baseball.ballType.BallType;
import baseball.ballType.Nothing;
import baseball.ballType.Strike;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public List<BallType> gameStart(List<String> pitcherList, List<String> batterList) {
        List<BallType> resultList = new ArrayList<>();
        for (int swingIdx = 0; swingIdx < batterList.size(); swingIdx++) {
            resultList.add(progressGame(pitcherList, batterList.get(swingIdx), swingIdx));
        }
        return resultList;
    }

    public BallType progressGame(List<String> pitcherList, String swing, int swingIdx) {
        if (pitcherList.contains(swing)) {
            return (matchBallType(pitcherList, swing, swingIdx));
        }
        return new Nothing();
    }

    public BallType matchBallType(List<String> pitcherList, String swing, int swingIdx) {
        if (swing.equals(pitcherList.get(swingIdx))) return new Strike();
        return new Ball();
    }

}
