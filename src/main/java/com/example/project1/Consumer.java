package com.example.project1;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

//    @JmsListener(destination = "inmemory.queue")
@JmsListener(destination = "queue1.queue")
public void listenerQueue1(String message){
        System.out.println("Message from queue1: " + message);
    }
//    @JmsListener(destination = "queue2.queue")
//    public void listenerQueue2(String message){
//        System.out.println("Message from queue2: " + message);
//    }
}
