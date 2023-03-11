package e1.characterPackage;

import e1.Pair;

public interface MovementStrategy {
    boolean movementChecker(Pair<Integer, Integer> currentPosition, Pair<Integer, Integer> newPosition);
}
