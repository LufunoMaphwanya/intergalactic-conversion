package com.intergalactic.converter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class KnowledgeBase {

    static char[] romanChars = {};
    private Map<String, String> galacticTomanNumeralMap;

    public KnowledgeBase() {
        this.galacticTomanNumeralMap = new HashMap<>();
    }

    public void insertKnowledgeEntry(String galactic, String roman) {
        this.galacticTomanNumeralMap.put(galactic, roman);
    }

    public String retrieveKnowledgeEntry(String galactic) {
        return this.galacticTomanNumeralMap.get(galactic);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> iter = galacticTomanNumeralMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            sb.append(entry.getKey());
            sb.append('=').append('"');
            sb.append(entry.getValue());
            sb.append('"');
            if (iter.hasNext()) {
                sb.append(',').append(' ');
            }
        }
        return sb.toString();

    }
}


