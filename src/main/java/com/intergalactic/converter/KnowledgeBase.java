package src.main.java.com.intergalactic.converter;

import java.util.HashMap;
import java.util.Map;

public class KnowledgeBase {

    static char[] romanChars = {};
    private Map<Character, Character> galacticTomanNumeralMap;

    public KnowledgeBase() {
        this.galacticTomanNumeralMap = new HashMap<>();
    }

    public void insertKnowledgeEntry(Character galactic, Character roman) {
        this.galacticTomanNumeralMap.put(galactic, roman);
    }

    public Character retrieveKnowledgeEntry(Character galactic) {
        return this.galacticTomanNumeralMap.get(galactic);
    }

}
