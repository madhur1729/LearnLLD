package org.example;

import org.example.entities.Broker;
import org.example.entities.Isubcriber;
import org.example.entities.Message;
import org.example.entities.impl.DisplaySubscriber;

import java.util.concurrent.Flow;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException{
       Broker broker =Broker.getInstance();

        // --- Create Isubcribers ---
        Isubcriber sportsFan1 = new DisplaySubscriber("SportsFan1");
        Isubcriber sportsFan2 = new DisplaySubscriber("SportsFan2");
        Isubcriber techie1 = new DisplaySubscriber("Techie1");
        Isubcriber allNewsReader = new DisplaySubscriber("AllNewsReader");
//        Isubcriber systemAdmin = new AlertIsubcriber("SystemAdmin");

        // --- Create Topics and Subscriptions ---
        final String SPORTS_TOPIC = "SPORTS";
        final String TECH_TOPIC = "TECH";
        final String WEATHER_TOPIC = "WEATHER";

        broker.createTopic(SPORTS_TOPIC);
        broker.createTopic(TECH_TOPIC);
        broker.createTopic(WEATHER_TOPIC);

        broker.subscribe(SPORTS_TOPIC, sportsFan1);
        broker.subscribe(SPORTS_TOPIC, sportsFan2);
        broker.subscribe(SPORTS_TOPIC, allNewsReader);
//        broker.subscribe(SPORTS_TOPIC, systemAdmin);

        broker.subscribe(TECH_TOPIC, techie1);
        broker.subscribe(TECH_TOPIC, allNewsReader);

        System.out.println("\n--- Publishing Messages ---");

        // --- Publish to SPORTS topic ---
        broker.publish(SPORTS_TOPIC, new Message("Team A wins the championship!"));
        // Expected: SportsFan1, SportsFan2, AllNewsReader, SystemAdmin receive this.

        // --- Publish to TECH topic ---
        broker.publish(TECH_TOPIC, new Message("New AI model released."));
        // Expected: Techie1, AllNewsReader receive this.

        // --- Publish to WEATHER topic (no subscribers) ---
        broker.publish(WEATHER_TOPIC, new Message("Sunny with a high of 75°F."));
        // Expected: Message is dropped.

        // Allow some time for async messages to be processed
        Thread.sleep(500);

        System.out.println("\n--- Unsubscribing a user and re-publishing ---");

        // SportsFan2 gets tired of sports news
        broker.unsubscribe(SPORTS_TOPIC, sportsFan2);

        // Publish another message to SPORTS
        broker.publish(SPORTS_TOPIC, new Message("Major player traded to Team B."));
        // Expected: SportsFan1, AllNewsReader, SystemAdmin receive this. SportsFan2 does NOT.

        // Give messages time to be delivered
        Thread.sleep(500);

        // --- Shutdown the service ---
//        broker.shutdown();
    }
}