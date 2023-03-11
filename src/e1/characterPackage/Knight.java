package e1.characterPackage;

import e1.Pair;

public class Knight implements MovementStrategy {

    @Override
    public boolean movementChecker(Pair<Integer, Integer> currentPosition, Pair<Integer, Integer> newPosition) {
        int rowDifference = newPosition.getX() - currentPosition.getX();
        int colDifference = newPosition.getY() - currentPosition.getY();
        return (rowDifference != 0 && colDifference != 0 && Math.abs(rowDifference) + Math.abs(colDifference) == 3);
    }
}
