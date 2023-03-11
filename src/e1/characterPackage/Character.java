package e1.characterPackage;

import e1.Pair;

public class Character implements CheckPositionPresence {
    private final MovementStrategy movementStrategy;
    protected Pair<Integer,Integer> position;

    public Character(MovementStrategy movementStrategy, Pair<Integer,Integer> position){;
        this.movementStrategy = movementStrategy;
        this.position = position;
    }

    @Override
    public boolean checkPositionPresence(int row, int col) {
        return position.equals(new Pair<Integer, Integer>(row, col));
    }

    public boolean changeOfPosition(int row, int col) {
        Pair<Integer, Integer> newPosition = new Pair<Integer, Integer>(row, col);
        boolean thisChangeOfPositionIsLegal = movementStrategy.movementChecker(this.position, newPosition);
        if(thisChangeOfPositionIsLegal){
            this.position = newPosition;
        }
        return thisChangeOfPositionIsLegal;
    }
}
