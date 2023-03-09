package e1;

import e1.characterPackage.Character;
import e1.characterPackage.CharacterFactory;

import java.util.*;

public class LogicsImpl implements Logics {
	private final Character pawn;
	private final Character knight;
	private final int size;

	public LogicsImpl(int size, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition){
		this.size = size;
		this.pawn = CharacterFactory.makePawn(getPosition(pawnPosition));
		this.knight = CharacterFactory.makeKnight(getPosition(knightPosition));
	}

    public LogicsImpl(int size) {
		this(size, null, null);
	}

	public Pair<Integer,Integer> getPosition(Pair<Integer, Integer> coordinate){
		Random random = new Random();
		coordinate = (coordinate != null) ? coordinate : new Pair<Integer, Integer>(random.nextInt(size), random.nextInt(size));
		return this.hasCharacter(coordinate) ? this.getPosition(null) : coordinate;
	}
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		// Below a compact way to express allowed moves for the knight
		if (knight.move(row, col)) {
			return hasPawn(row, col);
		}
		return false;
	}

	public boolean hasCharacter(Pair<Integer, Integer> coordinate){
		int row = coordinate.getX();
		int col = coordinate.getY();
		return hasKnight(row, col) || hasPawn(row, col);
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight != null && this.knight.CheckPositionPresence(row, col);
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn != null && this.pawn.CheckPositionPresence(row, col);
	}
}
