package org.example.entities;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;

public class Topic {
    private String id;
    private Set<Isubcriber> subs;
    private final ExecutorService deliveryExecutor;


    public Topic(String id, ExecutorService deliveryExecutor){
        this.id = id;
        this.subs = new CopyOnWriteArraySet<>();
        this.deliveryExecutor = deliveryExecutor;
    }

    public String getId() {
        return this.id;
    }

    public void addSubscribe(Isubcriber sub){
        System.out.println(sub.getId() + " subed to " + this.id);
        subs.add(sub);
    }
    public void removeSubscribe(Isubcriber sub){
        System.out.println(sub.getId() + " unsubed to " + this.id);
        subs.remove(sub);
    }

    public void notify(Message m){
        // sync
//        for( Isubcriber sub : subs ){
//            sub.recieve(m);
//            System.out.println("pushed msg to " + sub.getId());
//        }
        //async
        for( Isubcriber sub : subs ) {
            deliveryExecutor.submit(() -> {
                try {
                    sub.recieve(m);
                    System.out.println("pushed msg to " + sub.getId());
                } catch (Exception e) {
                    System.err.println("Error delivering message to subscriber " + sub.getId() + ": " + e.getMessage());
                }
            });
        }

//        pull type
//        for( Isubcriber sub : subs ){
//            queue.addmessage(m);
//        }
    }
}
