package org.example.entities;

public class Message {
    private String payload;

    public Message(String payload){
        this.payload = payload;
    }

    public String getPayload(){
        return this.payload;
    }
}
