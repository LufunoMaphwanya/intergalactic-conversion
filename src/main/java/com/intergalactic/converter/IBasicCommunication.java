package src.main.java.com.intergalactic.converter;

public interface IBasicCommunication {
    void receiveInfo(String i);

    String respond() throws UnderstandingException;
}
