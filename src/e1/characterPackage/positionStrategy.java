package e1.characterPackage;

import e1.Pair;

public abstract class positionStrategy implements CheckPositionPresence {
    protected Pair<Integer,Integer> position;

    abstract boolean move(int row, int col);

    public boolean CheckPositionPresence(int row, int col) {
        return position.equals(new Pair<Integer, Integer>(row, col));
    }
}
