package e1;

import e1.characterPackage.CheckPositionPresence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


public class LogicImplTest {

    LogicsImpl logics;

    private final int SIZE_OF_GUI = 7;

    @Nested
    class RandomPositionTests{
        @BeforeEach
        public void beforeEach(){
            logics = new LogicsImpl(SIZE_OF_GUI);
        }

        @Test
        public void knightIsInstantiatedTest() {
            assertNotNull(getPositionOfKnight());
        }

        @Test
        public void PawnIsInstantiatedTest() {
            assertNotNull(getPositionOfPawn());
        }

        @Test
        public void PawnAndKnightAreNotInTheSamePosition() {
           assertNotEquals(getPositionOfKnight(), getPositionOfPawn());
        }

        @Test
        public void hitWithWrongCoordinate() {
            Random random = new Random();
            int randomNumber = random.nextInt();
            int nRandomNumberGreaterThanSizeOfGui = random.nextInt(SIZE_OF_GUI + 1, Integer.MAX_VALUE);
            assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(randomNumber, nRandomNumberGreaterThanSizeOfGui));
        }

        private Pair<Integer, Integer> getPositionOfKnight(){
            return getPositionOfCharacter((int row, int col) -> logics.hasKnight(row, col));
        }

        private Pair<Integer, Integer> getPositionOfPawn(){
            return getPositionOfCharacter((int row, int col) -> logics.hasPawn(row, col));
        }

        private Pair<Integer, Integer> getPositionOfCharacter(CheckPositionPresence checkPositionLogics) {
            Pair<Integer, Integer> pair = null;
            int row;
            int col;
            for (int i = 0; i < SIZE_OF_GUI * SIZE_OF_GUI; i++) {
                row = i / SIZE_OF_GUI;
                col = i % SIZE_OF_GUI;
                if (checkPositionLogics.checkPositionPresence(row, col)) {
                    pair = new Pair<Integer, Integer>(row, col);
                }
            }
            return pair;
        }
    }

    @Nested
    class SelectivePositionTests{
        Pair<Integer, Integer> knightPosition = new Pair<Integer, Integer>(0, 0);
        Pair<Integer, Integer> rightKnightMovementFinalPosition = new Pair<Integer, Integer>(2, 1);
        Pair<Integer, Integer> wrongKnightMovementFinalPosition = new Pair<Integer, Integer>(1, 1);

        Pair<Integer, Integer> pawnPosition = new Pair<Integer, Integer>(1, 2);

        @BeforeEach
        public void beforeEach(){
            logics = new LogicsImpl(SIZE_OF_GUI, pawnPosition, knightPosition);
        }

        @Test
        public void knightHitWrongPosition() {
            verifyPositionAndHit(wrongKnightMovementFinalPosition, false, false);
        }

        @Test
        public void knightHitRightPosition() {
            verifyPositionAndHit(rightKnightMovementFinalPosition, false, true);
        }

        @Test
        public void knightHitPawnPosition(){
            verifyPositionAndHit(pawnPosition, true, true);
        }

        private void verifyPositionAndHit(Pair<Integer, Integer> hitPosition, boolean movementWasCorrect, boolean pawnWasHitted){
            int xPosition = hitPosition.getX();
            int yPosition = hitPosition.getY();
            assertEquals(movementWasCorrect, logics.hit(xPosition, yPosition));
            assertEquals(pawnWasHitted, logics.hasKnight(xPosition, yPosition));
        }
    }
}
