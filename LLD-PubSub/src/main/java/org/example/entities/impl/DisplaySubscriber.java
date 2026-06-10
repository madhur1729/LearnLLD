package org.example.entities.impl;

import org.example.entities.Isubcriber;
import org.example.entities.Message;

public class DisplaySubscriber implements Isubcriber {
    private String id;

    public DisplaySubscriber(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void recieve (Message m){
        System.out.println(m.getPayload());
    }
}
