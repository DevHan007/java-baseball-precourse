package baseball.ballType;

public class BallType {
    protected String type = "";

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof BallType))
            return false;
        BallType ball = (BallType) o;
        return ball.type.equals(type);
    }
}
