package org.example.entities;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Broker {

    private static final Broker INSTANCE = new Broker(); //singleton

    List<Topic> topics;
    Map<String, Topic>  submap;
    private final ExecutorService deliveryExecutor;


    private Broker(){
        this.submap = new ConcurrentHashMap<>();

        this.deliveryExecutor = Executors.newCachedThreadPool();
    }

    public static Broker getInstance(){
        return INSTANCE;
    }

    public void publish(String type, Message m){
        Topic t = submap.get(type);
        t.notify(m);
        // push type
    }

    public void subscribe(String type , Isubcriber sub){
        Topic t = submap.get(type);
        //null check
        t.addSubscribe(sub);
    }

    public void unsubscribe(String type , Isubcriber sub){
        Topic t = submap.get(type);
        //null check
        t.removeSubscribe(sub);
    }

    public void createTopic(String type){
        submap.putIfAbsent(type, new Topic(type, deliveryExecutor));
        System.out.println("Topic " + type + " created");
    }

}
