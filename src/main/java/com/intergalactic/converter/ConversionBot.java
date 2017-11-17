package com.intergalactic.converter;


import static com.intergalactic.converter.NumberConversionUtil.romanToDecimal;

public class ConversionBot implements IBasicCommunication {
    private KnowledgeBase knowledgeBase;

    public ConversionBot() {
        this.knowledgeBase = new KnowledgeBase();
    }

    @Override
    public void receiveInfo(String statement) throws Exception {

        if (!isQuestion(statement)) {

            if (statement.split(" ").length == 3) {
                    knowledgeBase.insertKnowledgeEntry(extractKey(statement),
                            extractValue(statement));
            } else {
                try {
                    receiveInfo(createStatement(statement));
                } catch (Exception ex) {

                }
            }

        } else {

                System.out.println(respond(statement));
        }
    }

    @Override
    public String respond(String question) throws Exception {
        String response = createRomanExpression(question);
        return response;
    }

    private String createRomanExpression(String question) throws Exception {

        question = question.substring(0, question.length() - 1);
        String[] args = question.split(" ");

        String romanExpression = knowledgeBase.retrieveKnowledgeEntry(args[4].trim())
                + knowledgeBase.retrieveKnowledgeEntry(args[5].trim())
                + knowledgeBase.retrieveKnowledgeEntry(args[6].trim());

        int result = romanToDecimal(romanExpression);
        return String.format("%s %s %s is %d", args[4], args[5], args[6], result);

    }

    private boolean isQuestion(String statement) {
        return statement.endsWith("?");
    }

    private String extractKey(String statement) {
        return statement.split(" ")[0];
    }

    private String extractValue(String statement) throws Exception {
        return statement.split(" ")[2];

    }

    private String createStatement(String statement) throws Exception {

        String[] args = statement.split(" ");

        Integer result = Integer.parseInt(args[4]);
        String character = guessMissingCharacter(args[0], args[1], args[2], result);


        if (character != null) {
            String derivedStatement = args[2] + " is " + character;
            return derivedStatement;
        }


        return null;
    }

    private String guessMissingCharacter(String known1, String known2, String unknown, Integer result) throws Exception {

        String[] validRomanChars = {"I", "V", "X", "L", "M", "C", "D"};


        for (String c : validRomanChars) {

//            System.out.println("knowledge base: " + knowledgeBase.toString());

            String c0 = knowledgeBase.retrieveKnowledgeEntry(known1.trim());
            String c1 = knowledgeBase.retrieveKnowledgeEntry(known2.trim());


            String romanExpression = c0.toString() + c1.toString() + c.toString();

            int calc = romanToDecimal(romanExpression);

            if (calc == result) {
                System.out.println("found a match");
                return c;
            }
        }

        throw new Exception("failed to guess missing symbol");

    }
}


