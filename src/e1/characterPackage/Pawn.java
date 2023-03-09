package e1.characterPackage;

import e1.Pair;

public class Pawn extends positionStrategy {
    public Pawn(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public boolean move(int row, int col) {
        return false;
    }

}
