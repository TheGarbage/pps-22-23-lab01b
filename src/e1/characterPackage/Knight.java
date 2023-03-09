package e1.characterPackage;

import e1.Pair;

public class Knight extends positionStrategy {

    public Knight(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public boolean move(int row, int col) {
        int rowDifference = row - this.position.getX();
        int colDifference = col - this.position.getY();
        if (rowDifference != 0 && colDifference != 0 && Math.abs(rowDifference) + Math.abs(colDifference) == 3) {
            this.position = new Pair<>(row,col);
            return true;
        }
        return false;
    }
}
