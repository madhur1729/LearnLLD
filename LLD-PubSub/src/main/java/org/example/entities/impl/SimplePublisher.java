package org.example.entities.impl;

import org.example.entities.Broker;
import org.example.entities.Ipublisher;
import org.example.entities.Message;
import org.example.entities.Topic;

public class SimplePublisher implements Ipublisher {
    String id;
    private Broker broker;

    public SimplePublisher(String id, Broker broker){
        this.broker = broker;
        this.id = id;
    }

    public void publish(Message m, String type){
        this.broker.publish(type, m);
        System.out.println("Published " + m.getPayload() + " by pub " + this.id + " to topic " + type);
    }
}
