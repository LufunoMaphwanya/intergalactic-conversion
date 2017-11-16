package src.main.java.com.intergalactic.converter;

public class ConversionBot implements IBasicCommunication {
    private KnowledgeBase knowledgeBase;

    public ConversionBot() {
        this.knowledgeBase = new KnowledgeBase();
    }

    @Override
    public void receiveInfo(String i) {
        System.out.println("received a iece of info:" + i);
    }

    @Override
    public void respond() throws UnderstandingException {
        System.out.println("responding with");
    }
}
