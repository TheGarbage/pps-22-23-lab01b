package e1.characterPackage;

import e1.Pair;

public class CharacterFactory {
    static public Character makeKnight(Pair<Integer, Integer> position){
        return new Character(new Knight(position));
    }

    static public Character makePawn(Pair<Integer, Integer> position){
        return new Character(new Pawn(position));
    }
}
