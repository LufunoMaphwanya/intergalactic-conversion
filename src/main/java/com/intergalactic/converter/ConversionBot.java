package src.main.java.com.intergalactic.converter;

public class ConversionBot implements IBasicCommunication {
    @Override
    public void receiveInfo(String i) {
        System.out.println("received a iece of info:" + i);
    }

    @Override
    public String respond() throws UnderstandingException {
        return ("responding with");
    }
}
