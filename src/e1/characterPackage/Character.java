package e1.characterPackage;

public class Character implements CheckPositionPresence {
    private final positionStrategy movementStrategy;

    public Character(positionStrategy movementStrategy){;
        this.movementStrategy = movementStrategy;
    }

    @Override
    public boolean CheckPositionPresence(int row, int col) {
        return movementStrategy.CheckPositionPresence(row, col);
    }

    public boolean move(int row, int col) {
        return movementStrategy.move(row, col);
    }
}
