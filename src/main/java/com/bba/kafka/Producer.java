package com.bba.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private String topic;

    Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(SampleMessage message) throws InterruptedException {
        topic = "4qet2sil-default";
        while(true){
            Thread.sleep(1000);
            this.kafkaTemplate.send(topic, message.getMessage());
            System.out.println("Sent sample message [" + message + "] to " + topic);
        }

    }

}