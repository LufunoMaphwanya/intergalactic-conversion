package com.intergalactic.converter;

public interface IBasicCommunication {
    void receiveInfo(String i) throws Exception;

    String respond(String question) throws Exception;
}
