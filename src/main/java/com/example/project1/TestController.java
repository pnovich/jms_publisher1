package com.example.project1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
public class TestController {
    @GetMapping("/")
    public String defaultString(){
        return "main default string";
    }

    @GetMapping("/special")
    public String specialtString(){
        return "special string";
    }

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("default")
    private Queue queue;

    @Autowired
    @Qualifier("queue1")
    private Queue queue1;

    @Autowired
    @Qualifier("queue2")
    private Queue queue2;



    @GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable("message")
                                 final String message){
        jmsTemplate.convertAndSend(queue,message);
        return "published";
    }

    @GetMapping("/push/{message}")
    public String publishMessageToQueue(@PathVariable("message")
                                 final String message){
        jmsTemplate.convertAndSend(queue1,message);
        jmsTemplate.convertAndSend(queue2, message);
        return "published";
    }

    @GetMapping("/push1/{message}")
    public String publishMessageToQueue1(@PathVariable("message")
                                        final String message){
        jmsTemplate.convertAndSend(queue1,message);
//        jmsTemplate.convertAndSend(queue2, message);
        return "published";
    }

    @GetMapping("/push2/{message}")
    public String publishMessageToQueue2(@PathVariable("message")
                                        final String message){
//        jmsTemplate.convertAndSend(queue1,message);
        jmsTemplate.convertAndSend(queue2, message);
        return "published";
    }


//    @GetMapping("/publish/{message}")
//    public String publishMessageToQueue2(@PathVariable("message")
//                                 final String message){
//        jmsTemplate.convertAndSend(queue,message);
//        return "published";
//    }

}
