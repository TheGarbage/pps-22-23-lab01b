package e1.characterPackage;

import e1.Pair;

public class Pawn implements MovementStrategy {
    @Override
    public boolean movementChecker(Pair<Integer, Integer> currentPosition, Pair<Integer, Integer> newPosition) {
        return false;
    }

}
